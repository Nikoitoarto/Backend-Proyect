package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesDocencia;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesDocenciaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_docencia")
public class ActividadesDocenciaController extends ABaseController<ActividadesDocencia, IActividadesDocenciaService> {
    public ActividadesDocenciaController(IActividadesDocenciaService service) {
        super(service, "Actividades");
    }
}

