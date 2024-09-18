package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.RevisionFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRevisionFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisionFormularioService extends ABaseService<RevisionFormulario> implements IRevisionFormularioService {


    @Override
    protected IAbaseRepository<RevisionFormulario, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<RevisionFormulario, Long> repository;
}

