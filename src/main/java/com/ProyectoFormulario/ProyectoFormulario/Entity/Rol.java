package com.ProyectoFormulario.ProyectoFormulario.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol extends AbaseEntity {

    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_rol", nullable = false)
    private TipoRol tipoRol;

    public enum TipoRol {
        Docente,
        Decano,
        Vicerrectoria,
        DireccionPrograma,
        AdministradorSistema
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rol_modulo",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private Set<Modulo> modulos = new HashSet<>();



    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }


}
