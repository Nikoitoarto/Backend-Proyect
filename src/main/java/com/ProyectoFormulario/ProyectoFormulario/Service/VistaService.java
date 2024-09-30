package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Vista;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IVistaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VistaService extends ABaseService<Vista> implements IVistaService {
    @Override
    protected IBaseRepository<Vista, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IVistaRepository repository;
}