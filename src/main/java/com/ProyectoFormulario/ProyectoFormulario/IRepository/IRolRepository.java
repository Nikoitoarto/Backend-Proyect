package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRolRepository extends IAbaseRepository<Rol, Long> {
     List<Rol> findByTipoRol(Rol.TipoRol tipoRol);
}
