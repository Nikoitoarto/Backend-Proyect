package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "formulario")
public class Formulario extends ABaseEntity{

    @Column(name = "fecha_formulario", length = 50, nullable = false)
    private LocalDateTime fechaFormulario;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoFormulario estado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "formulario_id")
    private List<AsignaturaDocencia> asignaturas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "formulario_id")
    private List<Actividades> actividades;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL)
    private Set<RevisionFormulario> revisiones;


    // Métodos para agregar asignaturas y actividades
    public void addAsignatura(AsignaturaDocencia asignatura) {
        asignaturas.add(asignatura);
        asignatura.setFormulario(this);
    }

    public void addActividad(Actividades actividad) {
        actividades.add(actividad);
        actividad.setFormulario(this);
    }

    public EstadoFormulario getEstado() {
        return estado;
    }

    public void setEstado(EstadoFormulario estado) {
        this.estado = estado;
    }

    public Set<RevisionFormulario> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(Set<RevisionFormulario> revisiones) {
        this.revisiones = revisiones;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
