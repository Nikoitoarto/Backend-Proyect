package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ActividadesLaboresDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesLaboresService;
import com.ProyectoFormulario.ProyectoFormulario.IService.IFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_labores")
public class ActividadesLaboresController extends ABaseController<ActividadesLabores, IActividadesLaboresService>{

    @Autowired
    private IFormularioService formularioService;

    @Autowired
    private IActividadesLaboresService actividadesLaboresService;// Declaración del controlador de formularios

    public ActividadesLaboresController(IActividadesLaboresService service) {
        super(service, "ActividadesLabores");
    }

    @PostMapping("/crear_actividad")
    public ResponseEntity<ApiResponseDto<ActividadesLabores>> saveActividad(@RequestBody ActividadesLaboresDto actividadesLaboresDto) {
        try {
            // Utilizar el método findById del ABaseController para buscar el formulario
            Long formularioId = actividadesLaboresDto.getFormularioId();
            Formulario formulario = obtenerFormularioPorId(formularioId);// Método para obtener el usuario por su ID

            // Crear la actividad
            ActividadesLabores actividad = new ActividadesLabores();
            actividad.setActividad(actividadesLaboresDto.getActividadesLabores().getActividad());
            actividad.setDescripcionActividad(actividadesLaboresDto.getActividadesLabores().getDescripcionActividad());
            actividad.setProducto(actividadesLaboresDto.getActividadesLabores().getProducto());
            actividad.setHorasSemanales(actividadesLaboresDto.getActividadesLabores().getHorasSemanales());
            actividad.setHorasSemestre(actividadesLaboresDto.getActividadesLabores().getHorasSemestre());
            actividad.setTotalHorasSemanales(actividadesLaboresDto.getActividadesLabores().getTotalHorasSemanales());
            actividad.setTotalHorasSemestre(actividadesLaboresDto.getActividadesLabores().getTotalHorasSemestre());

            // Ligar el formulario a la actividad
            actividad.setFormulario(formulario);

            // Guardar la actividad
            ActividadesLabores nuevaActividad = actividadesLaboresService.save(actividad);

            return ResponseEntity.ok(new ApiResponseDto<>("Actividad guardada correctamente", nuevaActividad, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }


    // Método auxiliar para obtener Usuario
    private Formulario obtenerFormularioPorId(Long formularioId) throws Exception {
        // Intenta obtener el formulario desde el servicio
        Formulario formulario = formularioService.findById(formularioId);
        if (formulario == null) {
            throw new Exception("Formulario no encontrado con id: " + formularioId);
        }
        return formulario;
    }


}

