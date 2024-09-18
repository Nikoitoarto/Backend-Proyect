package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermisoRepository extends JpaRepository<Permiso, Long> {
}
