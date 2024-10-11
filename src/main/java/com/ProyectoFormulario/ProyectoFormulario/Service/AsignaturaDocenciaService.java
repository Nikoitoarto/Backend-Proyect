package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAsignaturaDocenciaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAsignaturaDocenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AsignaturaDocenciaService extends ABaseService<AsignaturaDocencia> implements IAsignaturaDocenciaService {


    @Autowired
    private IAsignaturaDocenciaRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<AsignaturaDocencia, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    public List<AsignaturaDocencia> findByFormularioId(Long formularioId) {
        return repository.findByFormularioId(formularioId);
    }
}

