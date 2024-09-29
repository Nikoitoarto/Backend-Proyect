package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Vista;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VistaService extends ABaseService<Vista> implements IVistaService {


    @Autowired
    private IBaseRepository<Vista, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Vista, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}
