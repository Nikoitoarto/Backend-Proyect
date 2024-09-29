package com.ProyectoFormulario.ProyectoFormulario.Service;



import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.RevisionFormulario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IRevisionFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class RevisionFormularioService extends ABaseService<RevisionFormulario> implements IRevisionFormularioService {


    @Autowired
    private IBaseRepository<RevisionFormulario, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<RevisionFormulario, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }

    @Override
    public RevisionFormulario revisarFormulario(Long formularioId, Long perfilId, RevisionFormulario revision) throws Exception {
        // Asignar los datos de la revisión
        revision.setFormulario(new Formulario()); // Deberías obtener el formulario correspondiente
        revision.setRolRevisor(new Rol()); // Deberías obtener el perfil correspondiente
        revision.setFechaRevision(LocalDateTime.now());
        revision.setState(true); // Si necesitas setear el estado, puede ser un booleano

        // Guardar la revisión en la base de datos
        return save(revision);
    }

    @Override
    public RevisionFormulario.EstadoRevision obtenerEstadoRevision(Long revisionId) throws Exception {
        RevisionFormulario revision = findById(revisionId);
        return revision.getEstadoRevision();
    }


}

