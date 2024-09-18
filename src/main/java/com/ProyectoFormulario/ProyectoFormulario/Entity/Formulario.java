package com.ProyectoFormulario.ProyectoFormulario.Entity;

import jakarta.persistence.*;
import org.springframework.data.history.Revision;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "formulario")
public class Formulario extends AbaseEntity{

    @Column(name = "fecha_formulario", length = 50, nullable = false)
    private LocalDateTime fechaFormulario;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "nombre_profesor", length = 100, nullable = false)
    private String nombreProfesor;

    @Column(name = "facultad", length = 100, nullable = false)
    private String facultad;

    @Column(name = "programa", length = 100, nullable = false)
    private String programa;

    @Column(name = "periodo", length = 100, nullable = false)
    private String periodo;

    @Column(name = "total_horas", nullable = false)
    private Integer totalHoras;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formulario_id")
    private List<AsignaturaDocencia> asignaturas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formulario_id")
    private List<Actividades> actividades;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL)
    private Set<RevisionFormulario> revisiones;

    public Set<RevisionFormulario> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(Set<RevisionFormulario> revisiones) {
        this.revisiones = revisiones;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<AsignaturaDocencia> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaDocencia> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividades> actividades) {
        this.actividades = actividades;
    }

    public Integer getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Integer totalHoras) {
        this.totalHoras = totalHoras;
    }

    public LocalDateTime getFechaFormulario() {
        return fechaFormulario;
    }

    public void setFechaFormulario(LocalDateTime fechaFormulario) {
        this.fechaFormulario = fechaFormulario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
