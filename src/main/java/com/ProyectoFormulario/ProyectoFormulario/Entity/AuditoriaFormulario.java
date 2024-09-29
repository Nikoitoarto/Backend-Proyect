package com.ProyectoFormulario.ProyectoFormulario.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

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

    public enum EstadoAuditoria{
        Creado,
        Modificado,
        Enviado,
        Revisado,
    }

    @OneToMany(mappedBy = "auditoriaFormulario", cascade = CascadeType.ALL)
    private Set<RevisionFormulario> revisiones;


    public Set<RevisionFormulario> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(Set<RevisionFormulario> revisiones) {
        this.revisiones = revisiones;
    }

    public LocalDate getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDate fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public EstadoAuditoria getEstadoAuditoria() {
        return estadoAuditoria;
    }

    public void setEstadoAuditoria(EstadoAuditoria estadoAuditoria) {
        this.estadoAuditoria = estadoAuditoria;
    }


}
