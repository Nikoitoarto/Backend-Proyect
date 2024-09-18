package com.ProyectoFormulario.ProyectoFormulario.IService;


import com.ProyectoFormulario.ProyectoFormulario.Entity.AbaseEntity;

import java.util.List;

public interface IAbaseService<T extends AbaseEntity>  {


    List<T> all();
    List<T> findByStateTrue();
    T findById(Long id) throws Exception;
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;

}
