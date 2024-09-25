package com.ProyectoFormulario.ProyectoFormulario.IService;

import com.ProyectoFormulario.ProyectoFormulario.Entity.RevisionFormulario;

import java.util.List;

public interface IRevisionFormularioService extends IAbaseService<RevisionFormulario> {
    RevisionFormulario revisarFormulario(Long formularioId, Long perfilId, RevisionFormulario revision) throws Exception; // Asegúrate de lanzar una excepción si ocurre un error
    RevisionFormulario.EstadoRevision obtenerEstadoRevision(Long revisionId) throws Exception;
}
