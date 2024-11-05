package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IRolRepository extends IBaseRepository<Rol, Long> {
     Optional<Rol> findByTipoRol(TipoRol tipoRol);
}
