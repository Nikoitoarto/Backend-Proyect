package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modulo")
public class Modulo extends ABaseEntity{

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vista> Vistas = new HashSet<>();


    public Set<Vista> getVistas() {
        return Vistas;
    }

    public void setVistas(Set<Vista> vistas) {
        Vistas = vistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
