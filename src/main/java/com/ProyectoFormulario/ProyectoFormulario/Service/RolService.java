package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;

import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService extends ABaseService<Rol> implements IRolService {


    @Autowired
    private IRolRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Rol, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }


}

