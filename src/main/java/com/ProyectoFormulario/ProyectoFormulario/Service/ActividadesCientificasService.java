package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesCientificas;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IActividadesCientificasRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IActividadesCientificasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadesCientificasService extends ABaseService<ActividadesCientificas> implements IActividadesCientificasService {

    @Autowired
    private IActividadesCientificasRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<ActividadesCientificas, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    public List<ActividadesCientificas> findByFormularioId(Long formularioId) {
        return repository.findByFormularioId(formularioId);
    }
}
