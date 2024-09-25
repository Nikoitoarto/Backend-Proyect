package com.ProyectoFormulario.ProyectoFormulario.IRepository;


import com.ProyectoFormulario.ProyectoFormulario.Entity.AbaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbaseRepository <T extends AbaseEntity, ID> extends JpaRepository<T, ID> {

}
