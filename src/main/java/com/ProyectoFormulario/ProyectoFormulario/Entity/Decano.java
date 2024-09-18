package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "decano")
public class Decano extends AbaseEntity{

    @Column(name = "dependencia", length = 50, nullable = false)
    private String dependencia;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "revision_id", nullable = false)
    private RevisionFormulario revision;

    public RevisionFormulario getRevision() {
        return revision;
    }

    public void setRevision(RevisionFormulario revision) {
        this.revision = revision;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}

