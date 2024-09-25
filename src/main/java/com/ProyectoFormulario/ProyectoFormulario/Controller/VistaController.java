package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Vista;
import com.ProyectoFormulario.ProyectoFormulario.IService.IVistaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/vista")
public class VistaController extends AbaseController<Vista, IVistaService> {

    public VistaController(IVistaService service) {
        super(service, "vista");
    }
}
