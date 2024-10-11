package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesAdministrativa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActividadesAdministrativaRepository extends IBaseRepository<ActividadesAdministrativa, Long> {
    List<ActividadesAdministrativa> findByFormularioId(Long formularioId);
}
