package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.FormularioDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.RevisionRequest;
import com.ProyectoFormulario.ProyectoFormulario.Entity.*;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IService.*;
import com.ProyectoFormulario.ProyectoFormulario.Service.*;
import com.ProyectoFormulario.ProyectoFormulario.exceptions.RolNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/formulario")
@CrossOrigin(origins = "*")
public class FormularioController extends ABaseController<Formulario, IFormularioService> {


    public FormularioController(IFormularioService service) {
        super(service, "formulario");
    }

    @Autowired
    private IUsuarioService usuarioService; // Servicio para Usuario

    @Autowired
    private FormularioService formularioService;


    @PostMapping("/crear")
    public ResponseEntity<ApiResponseDto<Formulario>> crearFormulario(@RequestBody FormularioDto formularioDto) {
        try {

            // Imprime el DTO para verificar los valores
            System.out.println("Formulario DTO: " + formularioDto);

            Long usuarioId = formularioDto.getUsuarioId();
            Usuario usuario = obtenerUsuarioPorId(usuarioId);// Método para obtener el usuario por su ID

            // Crear una nueva instancia del formulario y establecer sus atributos
            Formulario formulario = new Formulario();
            formulario.setFechaFormulario(formularioDto.getFormulario().getFechaFormulario());
            formulario.setNombreProfesor(formularioDto.getFormulario().getNombreProfesor());
            formulario.setFacultad(formularioDto.getFormulario().getFacultad());
            formulario.setPrograma(formularioDto.getFormulario().getPrograma());
            formulario.setPeriodo(formularioDto.getFormulario().getPeriodo());
            // Asignar estado directamente desde el DTO
            formulario.setEstado(formularioDto.getFormulario().getEstado());

            // Obtener el rol de docente del usuario
            Rol rolDocente = usuario.getRoles().stream()
                    .filter(rol -> rol.getTipoRol() == TipoRol.DOCENTE)
                    .findFirst()
                    .orElseThrow(() -> new RolNoEncontradoException("Rol de docente no encontrado"));

            formulario.setRol(rolDocente); // Establecemos el rol en el formulario
            // Llamar al servicio para crear el formulario
            Formulario nuevoFormulario = formularioService.crearFormulario(formulario, usuario);
            // Crear respuesta de éxito
            ApiResponseDto<Formulario> response = new ApiResponseDto<>("Formulario creado exitosamente", nuevoFormulario, true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Crear respuesta de error
            ApiResponseDto<Formulario> response = new ApiResponseDto<>("Error al crear el formulario: " + e.getMessage(), null, false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    // Agregar AsignaturaDocencia al formulario
    @PostMapping("/{id}/asignatura-docencia")
    public ResponseEntity<AsignaturaDocencia> agregarAsignaturaDocencia(@PathVariable Long id, @RequestBody AsignaturaDocencia asignaturaDocencia) {
        try {
            AsignaturaDocencia asignatura = formularioService.agregarAsignaturaDocencia(id, asignaturaDocencia);
            return ResponseEntity.ok(asignatura);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Agregar ActividadesAdministrativa al formulario
    @PostMapping("/{id}/actividades-administrativas")
    public ResponseEntity<ActividadesAdministrativa> agregarActividadesAdministrativa(@PathVariable Long id, @RequestBody ActividadesAdministrativa actividadesAdministrativa) {
        try {
            ActividadesAdministrativa actividad = formularioService.agregarActividadesAdministrativa(id, actividadesAdministrativa);
            return ResponseEntity.ok(actividad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Agregar ActividadesCientificas al formulario
    @PostMapping("/{id}/actividades-cientificas")
    public ResponseEntity<ActividadesCientificas> agregarActividadesCientificas(@PathVariable Long id, @RequestBody ActividadesCientificas actividadesCientificas) {
        try {
            ActividadesCientificas actividad = formularioService.agregarActividadesCientificas(id, actividadesCientificas);
            return ResponseEntity.ok(actividad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Agregar ActividadesDocencia al formulario
    @PostMapping("/{id}/actividades-docencia")
    public ResponseEntity<ActividadesDocencia> agregarActividadesDocencia(@PathVariable Long id, @RequestBody ActividadesDocencia actividadesDocencia) {
        try {
            ActividadesDocencia actividad = formularioService.agregarActividadesDocencia(id, actividadesDocencia);
            return ResponseEntity.ok(actividad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Agregar ActividadesLabores al formulario
    @PostMapping("/{id}/actividades-laborales")
    public ResponseEntity<ActividadesLabores> agregarActividadesLabores(@PathVariable Long id, @RequestBody ActividadesLabores actividadesLabores) {
        try {
            ActividadesLabores actividad = formularioService.agregarActividadesLabores(id, actividadesLabores);
            return ResponseEntity.ok(actividad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Revisar formulario
    @PostMapping("/{id}/revisar")
    public ResponseEntity<String> revisarFormulario(@PathVariable Long id, @RequestBody RevisionRequest revisionRequest) {
        try {
            // Obtén el formulario a revisar
            Formulario formulario = formularioService.findById(id);

            // Obtén el usuario revisor
            Usuario usuario = usuarioService.findById(revisionRequest.getUsuarioId()); // Asegúrate de tener este método en UsuarioService

            // Realiza la revisión del formulario
            formularioService.revisarFormulario(formulario, usuario, revisionRequest.getComentario(), revisionRequest.getEstadoRevision());

            return ResponseEntity.ok("Revisión del formulario realizada con éxito.");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el formulario o usuario
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulario o Usuario no encontrado.");
        } catch (Exception e) {
            // Otros posibles errores
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al revisar el formulario: " + e.getMessage());
        }
    }

    // Obtener total de horas de un formulario
    @GetMapping("/{id}/total-horas")
    public ResponseEntity<Integer> calcularTotalHoras(@PathVariable Long id) {
        try {
            Formulario formulario = formularioService.findById(id);
            int totalHoras = formularioService.calcularTotalHoras(formulario);
            return ResponseEntity.ok(totalHoras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Método auxiliar para obtener Usuario
    private Usuario obtenerUsuarioPorId(Long usuarioId) throws Exception {
        // Intenta obtener el usuario desde el servicio
        Usuario usuario = usuarioService.findById(usuarioId);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado con id: " + usuarioId);
        }
        return usuario;
    }
}
