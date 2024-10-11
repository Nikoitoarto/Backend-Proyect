package com.ProyectoFormulario.ProyectoFormulario.Entity;


import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoRevision;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "revision_formulario")
public class RevisionFormulario extends ABaseEntity {

    @Column(name = "fecha_revision", nullable = false)
    private LocalDateTime fechaRevision;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_revision", nullable = false)
    private EstadoRevision estadoRevision;

    @Column(name = "comentario_revision", nullable = false)
    private String comentarioRevision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formulario_id", nullable = false)
    private Formulario formulario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rolRevisor;

    // Relación con Auditoría (opcional si llevas un registro)
    @ManyToOne
    @JoinColumn(name = "auditoriaFormulario_id", nullable = true)
    private AuditoriaFormulario auditoriaFormulario;


}
