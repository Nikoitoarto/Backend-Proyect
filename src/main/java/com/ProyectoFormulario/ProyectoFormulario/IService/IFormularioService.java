package com.ProyectoFormulario.ProyectoFormulario.IService;

import com.ProyectoFormulario.ProyectoFormulario.Entity.*;

public interface IFormularioService extends IAbaseService<Formulario> {

    Formulario crearFormulario(Formulario formulario);
    void diligenciarFormulario(Formulario formulario, Usuario usuario, AsignaturaDocencia asignatura, Actividades actividad) throws Exception;
    void revisarFormulario(Formulario formulario, Usuario usuario) throws Exception;
    void procesarFormulario(Formulario formulario, Usuario usuario) throws Exception;
}
