package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import com.ProyectoFormulario.ProyectoFormulario.Security.AuthService;
import com.ProyectoFormulario.ProyectoFormulario.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder; // Inyecta PasswordEncoder
    private final JwtUtils jwtUtils;
    private final IUsuarioService usuarioService;
    @Autowired
    public AuthController(AuthService authService, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, IUsuarioService usuarioService) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder; // Inicializa el PasswordEncoder
        this.jwtUtils = jwtUtils;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<LoginResponseDto>> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Llama al método de login en el servicio con los datos de LoginRequest
            ApiResponseDto<LoginResponseDto> response = usuarioService.login(
                    loginRequest.getNombreUsuario(), loginRequest.getContrasena()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseDto<>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
        }
    }




    // Clase interna para manejar el cuerpo de la solicitud de login
    public static class LoginRequest {
        private String nombreUsuario;
        private String contrasena;

        // Getters y Setters
        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }
    }
}
