package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actividades_Labores")
public class ActividadesLabores extends ABaseEntity{

    @Column(name = "actividad", nullable = false)
    private String actividad;

    @Column(name = "descripcion_actividad", nullable = false)
    private String descripcionActividad;

    @Column(name = "producto", nullable = false)
    private String producto;

    @Column(name = "horas_semanales", nullable = false)
    private Long horasSemanales;

    @Column(name = "horas_semestre", nullable = false)
    private Long horasSemestre;

    @Column(name = "total_horas_semanales", nullable = false)
    private Long totalHorasSemanales;

    @Column(name = "total_horas_semestre", nullable = false)
    private Long totalHorasSemestre;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

}
