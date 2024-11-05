package com.ProyectoFormulario.ProyectoFormulario.Controller;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/rol")
public class RolController extends ABaseController<Rol, IRolService> {
    public RolController(IRolService service) {
        super(service, "Rol");
    }


    @Autowired
    IRolRepository iRolRepository;

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> obtenerRoles() {
        List<Rol> roles = iRolRepository.findAll();
        return ResponseEntity.ok(roles);
    }

}
