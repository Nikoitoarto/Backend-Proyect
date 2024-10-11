package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAsignaturaDocenciaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/asignatura_docencia")
public class AsignaturaDocenciaController extends ABaseController<AsignaturaDocencia, IAsignaturaDocenciaService> {
    public AsignaturaDocenciaController(IAsignaturaDocenciaService service) {
        super(service, "AsignaturaDocencia");
    }
}

