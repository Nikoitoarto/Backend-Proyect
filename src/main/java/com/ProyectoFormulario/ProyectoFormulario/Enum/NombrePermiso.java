package com.ProyectoFormulario.ProyectoFormulario.Enum;

// NombrePermiso.java
public enum NombrePermiso {

    ACCESO_FORMULARIOCREAR("acceso:formulario"),
    ACCESO_REVISAR("acceso:revisar"),
    ACCESO_FORMULARIOEDITAR("acceso:formularioeditar"),
    VER_ACTIVIDADES("ver:actividades");

    private final String nombrePermiso;

    NombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }
}

