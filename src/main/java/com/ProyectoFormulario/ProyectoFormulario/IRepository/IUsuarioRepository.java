package com.ProyectoFormulario.ProyectoFormulario.IRepository;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Long> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
