package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IActividadesLaboresRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesLaboresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadesLaboresService extends ABaseService<ActividadesLabores> implements IActividadesLaboresService {

    @Autowired
    private IActividadesLaboresRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<ActividadesLabores, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    public List<ActividadesLabores> findByFormularioId(Long formularioId) {
        return repository.findByFormularioId(formularioId);
    }
}
