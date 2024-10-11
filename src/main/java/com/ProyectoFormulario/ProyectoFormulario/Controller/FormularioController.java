package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.*;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoRevision;
import com.ProyectoFormulario.ProyectoFormulario.IService.*;
import com.ProyectoFormulario.ProyectoFormulario.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/formulario")
@CrossOrigin(origins = "*")
public class FormularioController extends ABaseController<Formulario, IFormularioService> {


    @Autowired
    public FormularioController(IFormularioService service) {
        super(service, "formulario");
    }

    @Autowired
    private IUsuarioService usuarioService; // Servicio para Usuario

    @Autowired
    private FormularioService formularioService;


    // Crear formulario
    @PostMapping("/crear")
    public ResponseEntity<Formulario> crearFormulario(@RequestBody Formulario formulario, @RequestParam Long usuarioId) {
        try {
            Usuario usuario = obtenerUsuarioPorId(usuarioId); // Asume que tienes un método para obtener el usuario por su ID
            Formulario nuevoFormulario = formularioService.crearFormulario(formulario, usuario);
            return ResponseEntity.ok(nuevoFormulario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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
    public ResponseEntity<String> revisarFormulario(@PathVariable Long id, @RequestParam Long usuarioId,
                                                    @RequestParam String comentario, @RequestParam EstadoRevision estadoRevision) {
        try {
            // Obtén el formulario a revisar
            Formulario formulario = formularioService.findById(id);

            // Obtén el usuario revisor
            Usuario usuario = usuarioService.findById(usuarioId); // Asegúrate de tener este método en UsuarioService

            // Realiza la revisión del formulario
            formularioService.revisarFormulario(formulario, usuario, comentario, estadoRevision);

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
