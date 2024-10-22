package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesAdministrativa;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesAdministrativaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_administrativa")
public class ActividadesAdministrativaController extends ABaseController<ActividadesAdministrativa, IActividadesAdministrativaService>{
    public ActividadesAdministrativaController(IActividadesAdministrativaService service) {
        super(service, "ActividadesAdministrativas");
    }
}
