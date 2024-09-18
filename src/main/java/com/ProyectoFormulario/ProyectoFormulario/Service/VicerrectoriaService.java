package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Vicerrectoria;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IVicerrectoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VicerrectoriaService extends ABaseService<Vicerrectoria> implements IVicerrectoriaService {


    @Override
    protected IAbaseRepository<Vicerrectoria, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Vicerrectoria, Long> repository;
}

