package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDTO;
import com.ProyectoFormulario.ProyectoFormulario.Entity.RevisionFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRevisionFormularioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/revisionFormulario")
public class RevisionFormularioController extends AbaseController<RevisionFormulario, IRevisionFormularioService> {



    public RevisionFormularioController(IRevisionFormularioService service) {
        super(service, "Revision de Formulario");
    }

    @PostMapping("/revisar/{formularioId}/{perfilId}")
    public ResponseEntity<ApiResponseDTO<RevisionFormulario>> revisarFormulario(
            @PathVariable Long formularioId,
            @PathVariable Long perfilId,
            @RequestBody RevisionFormulario revision) {
        try {
            RevisionFormulario resultado = service.revisarFormulario(formularioId, perfilId, revision);
            return ResponseEntity.ok(new ApiResponseDTO<RevisionFormulario>("Formulario revisado correctamente", resultado, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<RevisionFormulario>(e.getMessage(), null, false));
        }
    }
    @GetMapping("/{id}/estado")
    public ResponseEntity<ApiResponseDTO<RevisionFormulario.EstadoRevision>> obtenerEstadoRevision(@PathVariable Long id) {
        try {
            RevisionFormulario.EstadoRevision estado = service.obtenerEstadoRevision(id);
            return ResponseEntity.ok(new ApiResponseDTO<>("Estado de revisión obtenido", estado, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<>(e.getMessage(), null, false));
        }
    }

}
