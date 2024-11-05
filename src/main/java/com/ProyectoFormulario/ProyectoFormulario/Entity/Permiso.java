package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.NombrePermiso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "permiso")
public class Permiso extends ABaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_permiso", nullable = false)
    private NombrePermiso nombrePermiso;

    @ManyToMany(mappedBy = "permisos", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Rol> roles = new HashSet<>();


    // Constructor que acepta TipoRol
    public Permiso(NombrePermiso nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
        this.roles = new HashSet<>(); // Inicializa la colección de permisos
    }

    // Constructor vacío requerido por JPA
    public Permiso() {}


}
