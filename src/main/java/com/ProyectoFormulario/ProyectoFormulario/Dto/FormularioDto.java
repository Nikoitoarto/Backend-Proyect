package com.ProyectoFormulario.ProyectoFormulario.Dto;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class FormularioDto {

    private Long usuarioId; // Este debería estar aquí
    private Formulario formulario; // Este objeto tiene que tener todos los atributos necesarios, incluyendo nombreProfesor

}
