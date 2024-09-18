package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Modulo;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModuloService extends ABaseService<Modulo> implements IModuloService {


    @Override
    protected IAbaseRepository<Modulo, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Modulo, Long> repository;
}

