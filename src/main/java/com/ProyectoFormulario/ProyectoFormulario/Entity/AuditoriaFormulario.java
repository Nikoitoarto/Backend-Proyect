package com.ProyectoFormulario.ProyectoFormulario.Entity;

import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoAuditoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "auditoria_formulario")
public class AuditoriaFormulario extends ABaseEntity{


    @Column(name = "fecha_accion", nullable = false)
    private LocalDate fechaAccion;

    @Column(name = "resultado", nullable = false)
    private String resultado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_auditoria")
    private EstadoAuditoria estadoAuditoria;

    @OneToMany(mappedBy = "auditoriaFormulario", cascade = CascadeType.ALL)
    private Set<RevisionFormulario> revisiones;




}
