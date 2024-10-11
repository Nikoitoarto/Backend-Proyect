package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import com.ProyectoFormulario.ProyectoFormulario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController extends ABaseController<Usuario, IUsuarioService> {

    public UsuarioController(IUsuarioService service) {
        super(service, "Usuario");
    }

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para crear un nuevo usuario
    @PostMapping("/crear")
    public ResponseEntity<ApiResponseDto<Usuario>> crearUsuario(@RequestBody ApiResponseDto<Usuario> usuarioDto) {
        ApiResponseDto<Usuario> respuesta = usuarioService.crearUsuario(usuarioDto);
        if (respuesta.getStatus()) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.badRequest().body(respuesta);
        }
    }


}
