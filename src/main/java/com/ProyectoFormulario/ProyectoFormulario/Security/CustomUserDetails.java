package com.ProyectoFormulario.ProyectoFormulario.Security;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CustomUserDetails implements UserDetails{


    private final Usuario usuario;

    public CustomUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = Stream.concat(
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getTipoRol().name())),  // Aquí el prefijo "ROLE_"
                usuario.getRoles().stream()
                        .flatMap(rol -> rol.getPermisos().stream())
                        .map(permiso -> new SimpleGrantedAuthority(permiso.getNombrePermiso().getNombrePermiso()))
        ).collect(Collectors.toList());

        System.out.println("User Authorities: " + authorities); // Verificar autoridades
        return authorities;
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
