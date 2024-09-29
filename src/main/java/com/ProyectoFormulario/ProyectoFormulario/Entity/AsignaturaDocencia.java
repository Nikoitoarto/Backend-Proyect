package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

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


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;


    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(String horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Long getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(Long horasSemestre) {
        this.horasSemestre = horasSemestre;
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

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
}
