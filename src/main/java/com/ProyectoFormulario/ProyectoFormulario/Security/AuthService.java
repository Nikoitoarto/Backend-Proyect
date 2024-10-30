package com.ProyectoFormulario.ProyectoFormulario.Security;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;
    private final JwtUtils jwtUtils; // Inyecta JwtUtils para generar tokens

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(IUsuarioRepository usuarioRepository, JwtUtils jwtUtils) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtils = jwtUtils;
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

        // Generar el token
        String token = jwtUtils.generateToken(nombreUsuario);

        // Crear el objeto de respuesta con los datos necesarios
        LoginResponseDto responseData = new LoginResponseDto(
                token,
                usuario.getNombreUsuario(),
                usuario.getPersona().getId(),
                usuario.getRoles().iterator().next().getId(),
                usuario.getContrasena()
        );

        return new ApiResponseDto<>("Login exitoso", responseData, true);
    }



    // Método requerido por UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Crea y devuelve un objeto UserDetails
        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getNombreUsuario())
                .password(usuario.getContrasena()) // La contraseña debe estar hasheada
                .roles(usuario.getRoles().stream().map(Rol::getTipoRol).toArray(String[]::new))
                .build();
    }

 }
