package com.ProyectoFormulario.ProyectoFormulario.Dto;


// Clase interna para manejar el cuerpo de la solicitud de login
public class LoginRequest {

    private String nombreUsuario;
    private String contrasena;

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}