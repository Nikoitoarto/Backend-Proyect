package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AuditoriaFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAuditoriaFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuditoriaFormularioService extends ABaseService<AuditoriaFormulario> implements IAuditoriaFormularioService {


    @Override
    protected IAbaseRepository<AuditoriaFormulario, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<AuditoriaFormulario, Long> repository;
}
