package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "revision_formulario")
public class RevisionFormulario extends AbaseEntity {

    @Column(name = "fecha_revision", nullable = false)
    private LocalDateTime fechaRevision;

    @Column(name = "estado_revision", nullable = false)
    private String estadoRevision;

    @Column(name = "comentario_revision", nullable = false)
    private LocalDateTime comentarioRevision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

    @ManyToOne
    @JoinColumn(name = "auditoriaFormulario_id", nullable = false)
    private AuditoriaFormulario auditoriaFormulario;


    public AuditoriaFormulario getAuditoriaFormulario() {
        return auditoriaFormulario;
    }

    public void setAuditoriaFormulario(AuditoriaFormulario auditoriaFormulario) {
        this.auditoriaFormulario = auditoriaFormulario;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public LocalDateTime getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDateTime fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(String estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public LocalDateTime getComentarioRevision() {
        return comentarioRevision;
    }

    public void setComentarioRevision(LocalDateTime comentarioRevision) {
        this.comentarioRevision = comentarioRevision;
    }
}
