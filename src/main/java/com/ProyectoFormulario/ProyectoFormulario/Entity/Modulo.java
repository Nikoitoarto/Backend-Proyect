package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
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


}
