package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;

import com.ProyectoFormulario.ProyectoFormulario.IService.IPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermisoService extends ABaseService<Permiso> implements IPermisoService {


    @Override
    protected IAbaseRepository<Permiso, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Permiso, Long> repository;
}

