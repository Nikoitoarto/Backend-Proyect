package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginRequest;
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

    @Autowired
    public AuthController(AuthService authService, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, IUsuarioService usuarioService) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder; // Inicializa el PasswordEncoder
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<LoginResponseDto>> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Llama al método de login en el servicio con los datos de LoginRequest
            ApiResponseDto<LoginResponseDto> response = authService.login(
                    loginRequest.getNombreUsuario(), loginRequest.getContrasena()
            );

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseDto<>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
        }
    }


}
