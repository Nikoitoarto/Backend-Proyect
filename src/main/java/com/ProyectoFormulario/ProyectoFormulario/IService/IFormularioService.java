package com.ProyectoFormulario.ProyectoFormulario.IService;

import com.ProyectoFormulario.ProyectoFormulario.Entity.*;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoRevision;

public interface IFormularioService extends IBaseService<Formulario> {

    Formulario crearFormulario(Formulario formulario, Usuario usuario)throws Exception;
    AsignaturaDocencia agregarAsignaturaDocencia(Long id, AsignaturaDocencia asignaturaDocencia) throws Exception;
    ActividadesAdministrativa agregarActividadesAdministrativa(Long id,  ActividadesAdministrativa actividadesAdministrativa) throws Exception;
    ActividadesCientificas agregarActividadesCientificas(Long id,  ActividadesCientificas actividadesCientificas) throws Exception;
    ActividadesDocencia agregarActividadesDocencia(Long id,  ActividadesDocencia actividadesDocencia) throws Exception;
    ActividadesLabores agregarActividadesLabores(Long id,  ActividadesLabores actividadesLabores) throws Exception;
    void revisarFormulario(Formulario formulario, Usuario usuario, String comentario, EstadoRevision estadoRevision) throws Exception;
}
