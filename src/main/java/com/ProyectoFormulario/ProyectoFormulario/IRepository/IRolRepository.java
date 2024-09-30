package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRolRepository extends IBaseRepository<Rol, Long> {
     List<Rol> findByTipoRol(TipoRol tipoRol);
}
