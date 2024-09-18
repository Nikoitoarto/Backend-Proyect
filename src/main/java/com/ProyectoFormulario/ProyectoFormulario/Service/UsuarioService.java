package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {


    @Override
    protected IAbaseRepository<Usuario, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IAbaseRepository<Usuario, Long> repository;
}

