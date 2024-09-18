package com.ProyectoFormulario.ProyectoFormulario.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "modulo")
public class Modulo extends AbaseEntity{

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "modulos")
    private Set<Perfil> perfiles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Set<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
}
