package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.AbaseEntity;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IAbaseService;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class ABaseService<T extends AbaseEntity> implements IAbaseService<T> {

    protected abstract IAbaseRepository<T, Long> getRepository();

    @Override
    public List<T> all(){
        return getRepository().findAll();
    }

    @Override
    public List<T> findByStateTrue(){
        return getRepository().findAll();
    }

    @Override
    public T findById(Long id) throws Exception{
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }

        return op.get();
    }

    @Override
    public T save(T entity) throws Exception{
        try{
            entity.setCreated_at(LocalDateTime.now());
            return getRepository().save(entity);
        }catch(Exception e){
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, T entity) throws Exception{
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDelete_at() != null) {
            throw new Exception("Registro inhabilitado");

        }

        T entityUpdate = op.get();

        String[] ignoreProperties = {"id", "createdAt", "deletedAt"};
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdate_at(LocalDateTime.now());
        getRepository().save(entityUpdate);
    }

    @Override
    public void delete(Long id) throws Exception{
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }

        T entityUpdate = op.get();
        entityUpdate.setDelete_at(LocalDateTime.now());

        getRepository().save(entityUpdate);
    }

}
