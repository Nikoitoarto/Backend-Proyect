package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador extends AbaseEntity{

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    public Perfil getPerfilId() {
        return perfil;
    }

    public void setPerfilId(Perfil perfilId) {
        this.perfil = perfil;
    }
}
