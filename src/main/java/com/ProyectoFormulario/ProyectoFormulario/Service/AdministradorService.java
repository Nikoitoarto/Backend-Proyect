package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Administrador;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdministradorService extends ABaseService<Administrador> implements IAdministradorService {

    @Override
    protected IAbaseRepository<Administrador, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Administrador, Long> repository;
}

