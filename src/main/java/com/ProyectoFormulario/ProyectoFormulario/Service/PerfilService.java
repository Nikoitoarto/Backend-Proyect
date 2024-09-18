package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Perfil;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;

import com.ProyectoFormulario.ProyectoFormulario.IService.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerfilService extends ABaseService<Perfil> implements IPerfilService {


    @Override
    protected IAbaseRepository<Perfil, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Perfil, Long> repository;
}

