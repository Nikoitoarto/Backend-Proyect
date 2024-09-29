package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AuditoriaFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAuditoriaFormularioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/auditoriaFormulario")
public class AuditoriaFormularioController extends ABaseController<AuditoriaFormulario, IAuditoriaFormularioService> {
    public AuditoriaFormularioController(IAuditoriaFormularioService service) {
        super(service, "AuditoriaFormulario");
    }
}
