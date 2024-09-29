package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AuditoriaFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAuditoriaFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuditoriaFormularioService extends ABaseService<AuditoriaFormulario> implements IAuditoriaFormularioService {


    @Autowired
    private IBaseRepository<AuditoriaFormulario, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<AuditoriaFormulario, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}
