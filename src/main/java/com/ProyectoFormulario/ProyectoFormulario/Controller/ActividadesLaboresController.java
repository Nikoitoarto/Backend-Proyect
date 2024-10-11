package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesLaboresService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_labores")
public class ActividadesLaboresController extends ABaseController{
    public ActividadesLaboresController(IActividadesLaboresService service) {
        super(service, "ActividadesLabores");
    }
}

