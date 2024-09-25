package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {


    @Autowired
    private IAbaseRepository<Usuario, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IAbaseRepository<Usuario, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}

