package com.ProyectoFormulario.ProyectoFormulario.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "perfil")
public class Perfil extends AbaseEntity {

    @Column(name = "nombre_perfil", nullable = false)
    private String nombrePerfil;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil")
    private TipoPerfil tipoPerfil;

    public enum TipoPerfil{
        Docente,
        Decano,
        Vicerrectoria,
        DireccionPrograma,
        AdministradorSistema
    }

    @ManyToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;

    @OneToOne(mappedBy = "perfil", fetch = FetchType.LAZY)
    private Docente docente;

    @OneToOne(mappedBy = "perfil", fetch = FetchType.LAZY)
    private Decano decano;

    @OneToOne(mappedBy = "perfil", fetch = FetchType.LAZY)
    private DirectorPrograma directorPrograma;

    @OneToOne(mappedBy = "perfil", fetch = FetchType.LAZY)
    private Vicerrectoria vicerrectoria;

    @OneToOne(mappedBy = "perfil", fetch = FetchType.LAZY)
    private Administrador administrador;

    @ManyToMany
    @JoinTable(
            name = "perfil_modulo",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private Set<Modulo> modulos;

    @ManyToMany
    @JoinTable(
            name = "perfil_vista",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "vista_id")
    )
    private Set<Vista> vistas;


    @ManyToMany
    @JoinTable(
            name = "perfil_permiso",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private Set<Permiso> permisos = new HashSet<>();

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Set<Vista> getVistas() {
        return vistas;
    }

    public void setVistas(Set<Vista> vistas) {
        this.vistas = vistas;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Decano getDecano() {
        return decano;
    }

    public void setDecano(Decano decano) {
        this.decano = decano;
    }

    public DirectorPrograma getDirectorPrograma() {
        return directorPrograma;
    }

    public void setDirectorPrograma(DirectorPrograma directorPrograma) {
        this.directorPrograma = directorPrograma;
    }

    public Vicerrectoria getVicerrectoria() {
        return vicerrectoria;
    }

    public void setVicerrectoria(Vicerrectoria vicerrectoria) {
        this.vicerrectoria = vicerrectoria;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
