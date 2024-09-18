package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import org.springframework.data.history.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRevisionFormularioRepository extends JpaRepository<Revision, Long> {
}
