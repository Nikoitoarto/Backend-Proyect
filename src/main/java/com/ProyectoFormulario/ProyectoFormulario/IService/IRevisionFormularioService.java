package com.ProyectoFormulario.ProyectoFormulario.IService;

import com.ProyectoFormulario.ProyectoFormulario.Entity.RevisionFormulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoRevision;

public interface IRevisionFormularioService extends IBaseService<RevisionFormulario> {
    RevisionFormulario revisarFormulario(Long formularioId, Long perfilId, RevisionFormulario revision) throws Exception; // Asegúrate de lanzar una excepción si ocurre un error
    EstadoRevision obtenerEstadoRevision(Long revisionId) throws Exception;
}
