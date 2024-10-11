package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "actividades_Labores")
@Entity
public class ActividadesLabores extends ABaseEntity{

    @Column(name = "actividad", nullable = false)
    private String actividad;

    @Column(name = "dedicacion_horas_Semanales", nullable = false)
    private Long dedicacionHorasSemanales;

    @Column(name = "dedicacion_horas_semestre", nullable = false)
    private Long dedicacionHorasSemestre;

    @Column(name = "descripcion_actividad", nullable = false)
    private String descripcionActividad;

    @Column(name = "producto", nullable = false)
    private String producto;

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
