package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAsignaturaDocenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsignaturaDocenciaService extends ABaseService<AsignaturaDocencia> implements IAsignaturaDocenciaService {


    @Override
    protected IAbaseRepository<AsignaturaDocencia, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<AsignaturaDocencia, Long> repository;
}

