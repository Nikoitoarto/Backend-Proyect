package com.ProyectoFormulario.ProyectoFormulario.Dto;

import com.ProyectoFormulario.ProyectoFormulario.Entity.ActividadesCientificas;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class FormularioDto {

    private Long usuarioId; // Este debería estar aquí
    private Formulario formulario;// Este objeto tiene que tener todos los atributos necesarios, incluyendo nombreProfesor
    private AsignaturaDocenciaDto asignaturaDocencia;
    private ActividadesLaboresDto actividadesLabores;
    private ActividadesDocenciaDto actividadesDocencia;
    private ActividadesAdministrativaDto actividadesAdministrativaDto;
    private ActividadesCientificas actividadesCientificas;
}
