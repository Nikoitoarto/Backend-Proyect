package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "actividades")
public class Actividades extends ABaseEntity{

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

    @Column(name = "total_horas_semanales", nullable = false)
    private Long totalHorasSemanales;

    @Column(name = "total_horas_semestre", nullable = false)
    private Long totalHorasSemestre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_actividad")
    private TipoActividad tipoActividad;

    public enum TipoActividad{
        Academicas,
        LaboresCientificas,
        LaboresCulturales,
        LaboresAdministrativas
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Long getDedicacionHorasSemanales() {
        return dedicacionHorasSemanales;
    }

    public void setDedicacionHorasSemanales(Long dedicacionHorasSemanales) {
        this.dedicacionHorasSemanales = dedicacionHorasSemanales;
    }

    public Long getDedicacionHorasSemestre() {
        return dedicacionHorasSemestre;
    }

    public void setDedicacionHorasSemestre(Long dedicacionHorasSemestre) {
        this.dedicacionHorasSemestre = dedicacionHorasSemestre;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getTotalHorasSemanales() {
        return totalHorasSemanales;
    }

    public void setTotalHorasSemanales(Long totalHorasSemanales) {
        this.totalHorasSemanales = totalHorasSemanales;
    }

    public Long getTotalHorasSemestre() {
        return totalHorasSemestre;
    }

    public void setTotalHorasSemestre(Long totalHorasSemestre) {
        this.totalHorasSemestre = totalHorasSemestre;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }


}
