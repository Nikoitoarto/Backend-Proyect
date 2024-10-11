package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Long> {
}
