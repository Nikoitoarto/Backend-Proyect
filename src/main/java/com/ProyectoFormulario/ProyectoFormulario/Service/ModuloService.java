package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Modulo;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModuloService extends ABaseService<Modulo> implements IModuloService {


    @Autowired
    private IAbaseRepository<Modulo, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IAbaseRepository<Modulo, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}

