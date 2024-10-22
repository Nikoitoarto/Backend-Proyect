package com.ProyectoFormulario.ProyectoFormulario.Controller;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesCientificas;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesCientificasService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/actividades_cientificas")
public class ActividadesCientificasController extends ABaseController<ActividadesCientificas, IActividadesCientificasService> {
    public ActividadesCientificasController(IActividadesCientificasService service) {
        super(service, "ActividadesCientificas");
    }
}
