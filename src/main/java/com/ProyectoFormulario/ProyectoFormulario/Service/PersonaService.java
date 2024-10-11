package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IPersonaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService extends ABaseService<Persona> implements IPersonaService {

    @Autowired
    private IPersonaRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Persona, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}
