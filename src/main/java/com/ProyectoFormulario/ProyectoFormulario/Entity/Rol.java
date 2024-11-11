package com.ProyectoFormulario.ProyectoFormulario.Entity;


import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "rol")
public class Rol extends ABaseEntity {

    @Enumerated(EnumType.STRING) // O EnumType.ORDINAL si prefieres usar índices
    @Column(name = "tipo_rol", nullable = false, unique = true)
    private TipoRol tipoRol;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name = "rol_permiso",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private Set<Permiso> permisos = new HashSet<>();

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Formulario> formularios = new HashSet<>();


    // Constructor que acepta TipoRol
    public Rol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
        this.permisos = new HashSet<>(); // Inicializa la colección de permisos
    }

    // Constructor vacío requerido por JPA
    public Rol() {}

    // Método para agregar permisos
    public void addPermiso(Permiso permiso) {
        this.permisos.add(permiso);
    }

}
