package com.ProyectoFormulario.ProyectoFormulario.IRepository;


import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesLabores;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActividadesLaboresRepository extends IBaseRepository<ActividadesLabores, Long>{
    List<ActividadesLabores> findByFormularioId(Long formularioId);
}
