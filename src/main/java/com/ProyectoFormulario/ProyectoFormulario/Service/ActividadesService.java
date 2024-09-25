package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Actividades;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ActividadesService extends ABaseService<Actividades> implements IActividadesService {

    @Autowired
    private IAbaseRepository<Actividades, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IAbaseRepository<Actividades, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

}
