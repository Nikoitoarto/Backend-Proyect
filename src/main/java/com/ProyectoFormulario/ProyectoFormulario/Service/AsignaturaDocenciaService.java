package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAsignaturaDocenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsignaturaDocenciaService extends ABaseService<AsignaturaDocencia> implements IAsignaturaDocenciaService {


    @Autowired
    private IAbaseRepository<AsignaturaDocencia, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IAbaseRepository<AsignaturaDocencia, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
}

