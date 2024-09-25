package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Vista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IVistaRepository extends JpaRepository<Vista, Long> {
}
