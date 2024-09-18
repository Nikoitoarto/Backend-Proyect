package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Docente;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocenteService extends ABaseService<Docente> implements IDocenteService {


    @Override
    protected IAbaseRepository<Docente, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Docente, Long> repository;
}

