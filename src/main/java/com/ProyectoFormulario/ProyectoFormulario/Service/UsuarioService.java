package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IPersonaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import com.ProyectoFormulario.ProyectoFormulario.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Agregar PasswordEncoder como dependencia

    @Override
    protected IBaseRepository<Usuario, Long> getRepository() {
        return repository;
    }

    public ApiResponseDto<Usuario> crearUsuario(UsuarioDto usuarioDto) throws Exception {
        // Obtener el rol usando el ID del DTO
        Rol rolEncontrado = rolRepository.findById(usuarioDto.getRolId())
                .orElseThrow(() -> new Exception("El Rol con ID " + usuarioDto.getRolId() + " no existe"));

        // Obtener la persona usando el ID del DTO
        Persona personaEncontrada = personaRepository.findById(usuarioDto.getPersonaId())
                .orElseThrow(() -> new Exception("La Persona con ID " + usuarioDto.getPersonaId() + " no existe"));

        // Crear un nuevo objeto Usuario y asignar los valores
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(usuarioDto.getUsuario().getNombreUsuario());

        // Hashear la contraseña
        String hashedPassword = passwordEncoder.encode(usuarioDto.getUsuario().getContrasena());
        nuevoUsuario.setContrasena(hashedPassword);

        // Asignar el rol
        Set<Rol> roles = new HashSet<>();
        roles.add(rolEncontrado);
        nuevoUsuario.setRoles(roles);

        // Asignar la persona encontrada
        nuevoUsuario.setPersona(personaEncontrada);

        // Guardar el usuario en la base de datos
        Usuario usuarioGuardado = repository.save(nuevoUsuario);

        // Retornar la respuesta
        return new ApiResponseDto<>("Usuario creado exitosamente", usuarioGuardado, true);
    }



    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception {
        return repository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Usuario con nombre " + nombreUsuario + " no encontrado"));
    }
}
