package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRolService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/rol")
public class RolController extends AbaseController<Rol, IRolService> {
    public RolController(IRolService service) {
        super(service, "perfil");
    }
}
