package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docente")
public class Docente extends AbaseEntity{

    @Column(name = "especialidad")
    private String especialidad;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    @OneToMany(mappedBy = "docente")
    private List<Formulario> formularios;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }
}
