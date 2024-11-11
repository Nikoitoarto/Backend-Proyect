package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Setter
@Getter
@Entity
@Table(name = "persona")
public class Persona extends ABaseEntity{

    @Column(name = "nombre", nullable = false, length = 250)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 250)
    private String apellido;

    @Column(name = "identificacion", nullable = false, unique = true, length = 120)
    private String identificacion;

    @Column(name = "telefono", length = 250)
    private String telefono;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

}
