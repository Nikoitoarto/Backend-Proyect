package com.ProyectoFormulario.ProyectoFormulario.Controller;

import ch.qos.logback.classic.Logger;
import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDTO;
import com.ProyectoFormulario.ProyectoFormulario.Entity.AbaseEntity;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAbaseService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
public abstract class AbaseController<T extends AbaseEntity, S extends IAbaseService<T>> {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AbaseController.class);
    protected S service;
    protected String entityName;

    protected AbaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseDTO<List<T>>> findByStateTrue() {
        try {
            return ResponseEntity.ok(new ApiResponseDTO<List<T>>("Datos obtenidos", service.findByStateTrue(), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<List<T>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO<T>> show(@PathVariable Long id) {

        try {
            T entity = service.findById(id);
            return ResponseEntity.ok(new ApiResponseDTO<>("Registro encontrado", entity, true));
        } catch (EntityNotFoundException e) {
            log.error("Entidad no encontrada: {}", id, e);
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            log.error("Violación de integridad de datos: {}", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>("Error de integridad de datos", null, false));
        } catch (Exception e) {
            log.error("Error inesperado: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<>("Error interno del servidor", null, false));
        }
    }

    @PostMapping("")
    public ResponseEntity<ApiResponseDTO<T>> save(@RequestBody T entity) {
        try {
            return ResponseEntity.ok(new ApiResponseDTO<T>("Datos guardados", service.save(entity), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<T>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDTO<T>> update(@PathVariable Long id, @RequestBody T entity) {
        try {
            service.update(id, entity);
            return ResponseEntity.ok(new ApiResponseDTO<T>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<T>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDTO<T>> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDTO<T>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDTO<T>(e.getMessage(), null, false));
        }
    }
}
