package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesAdministrativa;
import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesDocencia;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActividadesDocenciaRepository extends IBaseRepository<ActividadesDocencia, Long>{
    List<ActividadesDocencia> findByFormularioId(Long formularioId);

}
