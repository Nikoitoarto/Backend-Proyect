package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Actividades;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IActividadesRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ActividadesService extends ABaseService<Actividades> implements IActividadesService {

    @Autowired
    private IActividadesRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Actividades, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

}
