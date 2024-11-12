package com.ProyectoFormulario.ProyectoFormulario.Security;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.NombrePermiso;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IFormularioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;
    private final JwtUtils jwtUtils;
    private final IFormularioRepository formularioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(IUsuarioRepository usuarioRepository, JwtUtils jwtUtils, IFormularioRepository formularioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtils = jwtUtils;
        this.formularioRepository = formularioRepository;
    }

    public ApiResponseDto<LoginResponseDto> login(String nombreUsuario, String contrasena) throws Exception {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        // Verificar la contraseña
        boolean isPasswordMatch = passwordEncoder.matches(contrasena, usuario.getContrasena());
        System.out.println("Comparando contraseñas: " + isPasswordMatch);

        if (!isPasswordMatch) {
            throw new Exception("Contraseña incorrecta");
        }

        // Verifica si el usuario tiene una persona asociada y al menos un rol
        if (usuario.getPersona() == null) {
            throw new Exception("El usuario no tiene una persona asociada");
        }

        // Extraer los roles del usuario y convertirlos en una lista de strings
        List<String> roles = usuario.getRoles().stream()
                .map(rol -> rol.getTipoRol().name())
                .collect(Collectors.toList());

        if (usuario.getRoles().isEmpty()) {
            throw new Exception("El usuario no tiene roles asociados");
        }
        // Extraer los permisos de cada rol del usuario y almacenarlos en una lista de strings
        // Suponiendo que `usuario.getRoles()` devuelve una colección de roles
        List<String> permisos = usuario.getRoles().stream()
                .flatMap(rol -> rol.getPermisos().stream()) // Aplanar los permisos de cada rol
                .map(Permiso::getNombrePermiso)              // Obtener el nombre de cada permiso como NombrePermiso
                .map(NombrePermiso::getNombrePermiso)         // Convertir NombrePermiso a String
                .distinct()                                  // Eliminar duplicados si hay permisos repetidos entre roles
                .collect(Collectors.toList());               // Recoger en una lista

        // Filtrar los formularios pendientes del usuario logueado
        EstadoFormulario estadoFormulario = EstadoFormulario.PENDIENTE;
        List<Formulario> formularios = formularioRepository.findByEstadoAndUsuarioId(estadoFormulario, usuario.getId());
        System.out.println("Formularios pendientes para el usuario " + usuario.getNombreUsuario() + ": " + formularios);


        List<Long> formularioId = formularios.stream()
                .map(Formulario::getId)
                .collect(Collectors.toList());
        System.out.println("Formulario IDs: " + formularioId);


        // Verifica si la lista de formularioIds está vacía y maneja el caso en consecuencia
        if (formularioId.isEmpty()) {
            System.out.println("No hay formularios asignados para este usuario.");
            formularioId = Collections.emptyList(); // Asegura que la lista esté vacía en lugar de null
        }

        // Generar el token con el nombre de usuario, roles y permisos
        String token = jwtUtils.generateToken(nombreUsuario, roles, permisos, usuario.getId());

        // Crear el objeto de respuesta con los datos necesarios
        LoginResponseDto responseData = new LoginResponseDto(
                token,
                usuario.getNombreUsuario(),
                usuario.getPersona().getId(),
                usuario.getRoles().iterator().next().getId(),
                usuario.getContrasena(),
                formularioId,
                usuario.getId()

        );

        return new ApiResponseDto<>("Login exitoso", responseData, true);
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new CustomUserDetails(usuario);  // Delega a CustomUserDetails para manejar roles y permisos.
    }

}
