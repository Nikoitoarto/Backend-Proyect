package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Decano;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IDecanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DecanoService extends ABaseService<Decano> implements IDecanoService {


    @Override
    protected IAbaseRepository<Decano, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Decano, Long> repository;
}

