package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "permiso")
public class Permiso extends AbaseEntity {

    @Column(name = "nombre_permiso", nullable = false)
    private String nombrePermiso;

    @Column(name = "descripcion_permiso", nullable = false)
    private String descripcionPermiso;

    @ManyToMany(mappedBy = "permisos")
    private Set<Perfil> perfiles;

    @ManyToMany (mappedBy = "permiso")
    private Set<Usuario> usuarios;

    public Set<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Set<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
