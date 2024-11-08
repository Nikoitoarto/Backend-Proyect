package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import com.ProyectoFormulario.ProyectoFormulario.Enum.NombrePermiso;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPermisoRepository extends IBaseRepository<Permiso, Long> {
    Optional<Permiso> findByNombrePermiso(NombrePermiso nombrePermiso);
}
