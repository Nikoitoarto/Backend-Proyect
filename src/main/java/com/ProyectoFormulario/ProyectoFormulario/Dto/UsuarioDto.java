package com.ProyectoFormulario.ProyectoFormulario.Dto;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDto {

    private Long rolId; // ID del Rol existente
    private Long personaId;
    private Usuario usuario;
    private Rol rol;
    private Persona persona;// ID de la Persona existente
}
