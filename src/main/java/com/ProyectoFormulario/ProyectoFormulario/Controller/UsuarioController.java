package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder; // Importar PasswordEncoder
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController extends ABaseController<Usuario, IUsuarioService> {

    private final PasswordEncoder passwordEncoder; // Inyectar PasswordEncoder

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService service, PasswordEncoder passwordEncoder) {
        super(service, "Usuario");
        this.passwordEncoder = passwordEncoder; // Inicializar PasswordEncoder
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponseDto<Usuario>> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Llamar al servicio para crear el usuario usando el DTO directamente
            ApiResponseDto<Usuario> response = usuarioService.crearUsuario(usuarioDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejo de excepciones y respuesta de error
            return new ResponseEntity<>(new ApiResponseDto<>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
        }
    }

}
