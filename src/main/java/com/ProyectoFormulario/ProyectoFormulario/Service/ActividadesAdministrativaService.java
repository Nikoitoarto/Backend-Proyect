package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesAdministrativa;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IActividadesAdministrativaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesAdministrativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadesAdministrativaService extends ABaseService<ActividadesAdministrativa> implements IActividadesAdministrativaService {


    @Autowired
    private IActividadesAdministrativaRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<ActividadesAdministrativa, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    public List<ActividadesAdministrativa> findByFormularioId(Long formularioId) {
        return repository.findByFormularioId(formularioId);
    }


}
