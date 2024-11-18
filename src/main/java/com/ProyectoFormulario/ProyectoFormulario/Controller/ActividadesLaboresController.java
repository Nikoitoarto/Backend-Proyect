package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesLaboresService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_labores")
public class ActividadesLaboresController extends ABaseController<ActividadesLabores, IActividadesLaboresService>{


    public ActividadesLaboresController(IActividadesLaboresService service) {
        super(service, "ActividadesLabores");
    }

}

