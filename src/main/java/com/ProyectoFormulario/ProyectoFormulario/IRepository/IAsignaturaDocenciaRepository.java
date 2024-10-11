package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import com.ProyectoFormulario.ProyectoFormulario.Entity.AsignaturaDocencia;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAsignaturaDocenciaRepository extends IBaseRepository<AsignaturaDocencia, Long>{
    List<AsignaturaDocencia> findByFormularioId(Long formularioId);

}
