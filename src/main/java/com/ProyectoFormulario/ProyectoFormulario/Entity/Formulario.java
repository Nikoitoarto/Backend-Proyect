package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "formulario")
public class Formulario extends ABaseEntity{

    @Column(name = "fecha_formulario", length = 50, nullable = false)
    private LocalDateTime fechaFormulario;

    @Column(name = "nombre_profesor", length = 100, nullable = false)
    private String nombreProfesor;

    @Column(name = "facultad", length = 100, nullable = false)
    private String facultad;

    @Column(name = "programa", length = 100, nullable = false)
    private String programa;

    @Column(name = "periodo", length = 100, nullable = false)
    private String periodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoFormulario estado;

    @OneToOne(mappedBy = "formulario", fetch = FetchType.EAGER)
    private ActividadesAdministrativa actividadesAdministrativa;

    @OneToOne(mappedBy = "formulario", fetch = FetchType.EAGER)
    private ActividadesCientificas actividadesCientificas;

    @OneToOne(mappedBy = "formulario", fetch = FetchType.EAGER)
    private ActividadesDocencia actividadesDocencia;

    @OneToOne(mappedBy = "formulario", fetch = FetchType.EAGER)
    private ActividadesLabores actividadesLabores;

    @OneToOne(mappedBy = "formulario", fetch = FetchType.EAGER)
    private AsignaturaDocencia asignaturaDocencia;

    @OneToMany(mappedBy = "formulario",fetch = FetchType.EAGER)
    private Set<RevisionFormulario> revisiones;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;







}
