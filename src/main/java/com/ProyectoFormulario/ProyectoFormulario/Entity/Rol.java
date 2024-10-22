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

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "rol_modulo",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private Set<Modulo> modulos = new HashSet<>();



}
