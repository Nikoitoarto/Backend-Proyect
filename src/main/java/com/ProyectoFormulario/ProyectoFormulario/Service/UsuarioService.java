package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {


    @Autowired
    private IBaseRepository<Usuario, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Usuario, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}

