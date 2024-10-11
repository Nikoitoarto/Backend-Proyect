package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesCientificas;
import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesDocencia;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IActividadesDocenciaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesDocenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadesDocenciaService extends ABaseService<ActividadesDocencia> implements IActividadesDocenciaService {

    @Autowired
    private IActividadesDocenciaRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<ActividadesDocencia, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    public List<ActividadesDocencia> findByFormularioId(Long formularioId) {
        return repository.findByFormularioId(formularioId);
    }

}
