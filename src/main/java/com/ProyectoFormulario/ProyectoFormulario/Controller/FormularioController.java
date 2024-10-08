package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Actividades;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesService;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAsignaturaDocenciaService;
import com.ProyectoFormulario.ProyectoFormulario.IService.IFormularioService;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/formulario")
@CrossOrigin(origins = "*")
public class FormularioController extends ABaseController<Formulario, IFormularioService> {

    @Autowired
    private IUsuarioService usuarioService; // Servicio para Usuario

    @Autowired
    private IAsignaturaDocenciaService asignaturaService; // Servicio para AsignaturaDocencia

    @Autowired
    private IActividadesService actividadService; // Servicio para Actividades

    @Autowired
    public FormularioController(IFormularioService service) {
        super(service, "formulario");
    }

    @PutMapping("/diligenciar")
    public ResponseEntity<ApiResponseDto<Void>> diligenciarFormulario(
            @RequestBody Formulario formulario,
            @RequestParam Long usuarioId,
            @RequestParam Long asignaturaId,
            @RequestParam Long actividadId) {
        try {
            Usuario usuario = usuarioService.findById(usuarioId); // Obtener Usuario
            AsignaturaDocencia asignatura = asignaturaService.findById(asignaturaId); // Obtener Asignatura
            Actividades actividad = actividadService.findById(actividadId); // Obtener Actividad

            service.diligenciarFormulario(formulario, usuario, asignatura, actividad);
            return ResponseEntity.ok(new ApiResponseDto<>("Formulario diligenciado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @PutMapping("/revisar")
    public ResponseEntity<ApiResponseDto<Void>> revisarFormulario(
            @RequestBody Formulario formulario,
            @RequestParam Long usuarioId) {
        try {
            Usuario usuario = usuarioService.findById(usuarioId); // Obtener Usuario
            service.revisarFormulario(formulario, usuario);
            return ResponseEntity.ok(new ApiResponseDto<>("Formulario revisado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @PutMapping("/procesar")
    public ResponseEntity<ApiResponseDto<Void>> procesarFormulario(
            @RequestBody Formulario formulario,
            @RequestParam Long usuarioId) {
        try {
            Usuario usuario = usuarioService.findById(usuarioId); // Obtener Usuario
            service.procesarFormulario(formulario, usuario);
            return ResponseEntity.ok(new ApiResponseDto<>("Formulario procesado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}