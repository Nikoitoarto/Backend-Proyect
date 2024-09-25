package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Modulo;
import com.ProyectoFormulario.ProyectoFormulario.IService.IModuloService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modulo")
public class ModuloController extends AbaseController<Modulo, IModuloService> {
    public ModuloController(IModuloService service) {
        super(service, "modulo");
    }
}
