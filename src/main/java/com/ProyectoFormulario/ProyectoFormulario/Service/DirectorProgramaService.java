package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.DirectorPrograma;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IDirectorProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DirectorProgramaService extends ABaseService<DirectorPrograma> implements IDirectorProgramaService {


    @Override
    protected IAbaseRepository<DirectorPrograma, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<DirectorPrograma, Long> repository;
}

