package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import com.ProyectoFormulario.ProyectoFormulario.IService.IPermisoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/permiso")
public class PermisoController extends ABaseController<Permiso, IPermisoService> {
    public PermisoController(IPermisoService service) {
        super(service, "permiso");
    }
}
