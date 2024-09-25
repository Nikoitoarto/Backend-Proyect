package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "revision_formulario")
public class RevisionFormulario extends AbaseEntity {

    @Column(name = "fecha_revision", nullable = false)
    private LocalDateTime fechaRevision;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_revision", nullable = false)
    private EstadoRevision estadoRevision;

    @Column(name = "comentario_revision", nullable = false)
    private String comentarioRevision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Rol rolRevisor;

    // Relación con Auditoría (opcional si llevas un registro)
    @ManyToOne
    @JoinColumn(name = "auditoriaFormulario_id", nullable = true)
    private AuditoriaFormulario auditoriaFormulario;

    public enum EstadoRevision {
        PENDIENTE,
        APROBADO,
        RECHAZADO,
        EN_PROGRESO
    }

    public LocalDateTime getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDateTime fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public EstadoRevision getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(EstadoRevision estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public String getComentarioRevision() {
        return comentarioRevision;
    }

    public void setComentarioRevision(String comentarioRevision) {
        this.comentarioRevision = comentarioRevision;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Rol getRolRevisor() {
        return rolRevisor;
    }

    public void setRolRevisor(Rol rolRevisor) {
        this.rolRevisor = rolRevisor;
    }

    public AuditoriaFormulario getAuditoriaFormulario() {
        return auditoriaFormulario;
    }

    public void setAuditoriaFormulario(AuditoriaFormulario auditoriaFormulario) {
        this.auditoriaFormulario = auditoriaFormulario;
    }
}
