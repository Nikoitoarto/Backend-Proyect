package com.ProyectoFormulario.ProyectoFormulario.Security;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;



public class CustomUserDetails implements UserDetails{


    private final Usuario usuario;

    public CustomUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convierte los roles a GrantedAuthority, si es necesario
        return usuario.getRoles().stream()
                .map(rol -> (GrantedAuthority) () -> String.valueOf(rol.getTipoRol()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.getContrasena();
    }

    @Override
    public String getUsername() {
        return usuario.getNombreUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.getState();  // o algún campo que indique si el usuario está activo
    }
}
