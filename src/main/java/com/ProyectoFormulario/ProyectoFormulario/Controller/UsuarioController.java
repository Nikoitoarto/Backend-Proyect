package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
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
            // Crear un objeto Rol y Persona usando los IDs del DTO
            Rol rol = new Rol();
            rol.setId(usuarioDto.getRolId());

            Persona persona = new Persona();
            persona.setId(usuarioDto.getPersonaId());

            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(usuarioDto.getUsuario().getNombreUsuario()); // Asegúrate de que el DTO tenga este atributo

            // Hashear la contraseña antes de asignarla
            String hashedPassword = passwordEncoder.encode(usuarioDto.getUsuario().getContrasena()); // Asegúrate de que el DTO tenga este atributo
            nuevoUsuario.setContrasena(hashedPassword); // Asignar la contraseña hasheada

            // Llamar al servicio para crear el usuario
            ApiResponseDto<Usuario> response = usuarioService.crearUsuario(nuevoUsuario, rol, persona);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejo de excepciones y respuesta de error
            return new ResponseEntity<>(new ApiResponseDto<>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
        }
    }
}
