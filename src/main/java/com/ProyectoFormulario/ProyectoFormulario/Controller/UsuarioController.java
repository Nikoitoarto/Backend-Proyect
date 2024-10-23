package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import com.ProyectoFormulario.ProyectoFormulario.Service.PersonaService;
import com.ProyectoFormulario.ProyectoFormulario.Service.RolService;
import com.ProyectoFormulario.ProyectoFormulario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/crear")
    public ResponseEntity<ApiResponseDto<Usuario>> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Crear un objeto Rol y Persona usando los IDs del DTO
            Rol rol = new Rol();
            rol.setId(usuarioDto.getRolId());

            Persona persona = new Persona();
            persona.setId(usuarioDto.getPersonaId());

            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(usuarioDto.getUsuario().getNombreUsuario());
            nuevoUsuario.setContrasena(usuarioDto.getUsuario().getContrasena());

            // Llamar al servicio para crear el usuario
            ApiResponseDto<Usuario> response = usuarioService.crearUsuario(nuevoUsuario, rol, persona);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejo de excepciones y respuesta de error
            return new ResponseEntity<>(new ApiResponseDto<>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
        }
    }


}
