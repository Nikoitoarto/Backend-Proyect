package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFormularioRepository extends IBaseRepository<Formulario, Long>{
    List<Formulario> findByEstado(EstadoFormulario estado);

}
