package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.IService.IPersonaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persona")
public class PersonaController extends ABaseController {
    public PersonaController(IPersonaService service) {
        super(service, "Persona");
    }

}
