package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "asignatura_docencia")
public class AsignaturaDocencia extends ABaseEntity{

    @Column(name = "nombre_asignatura", nullable = false)
    private String nombre_asignatura;

    @Column(name = "programa", nullable = false)
    private String programa;

    @Column(name = "grupo", nullable = false)
    private String grupo;

    @Column(name = "sede", nullable = false)
    private String sede;

    @Column(name = "horas_semanales", nullable = false)
    private String horasSemanales;

    @Column(name = "horas_semestre", nullable = false)
    private Long horasSemestre;

    @Column(name = "total_horas_semanales", nullable = false)
    private Long totalHorasSemanales;

    @Column(name = "total_horas_semestre", nullable = false)
    private Long totalHorasSemestre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;


}
