package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Modulo;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IModuloRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModuloService extends ABaseService<Modulo> implements IModuloService {


    @Autowired
    private IModuloRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Modulo, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}

