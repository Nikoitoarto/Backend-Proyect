package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularioService extends ABaseService<Formulario> implements IFormularioService {


    @Override
    protected IAbaseRepository<Formulario, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Formulario, Long> repository;
}

