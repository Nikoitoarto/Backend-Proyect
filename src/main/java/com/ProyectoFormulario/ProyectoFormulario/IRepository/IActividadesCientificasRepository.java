package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesAdministrativa;
import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesCientificas;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActividadesCientificasRepository extends IBaseRepository<ActividadesCientificas, Long>{
    List<ActividadesCientificas> findByFormularioId(Long formularioId);
}
