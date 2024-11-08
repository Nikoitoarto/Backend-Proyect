package com.ProyectoFormulario.ProyectoFormulario.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthService authService; // Usamos tu servicio de autenticación para cargar los detalles del usuario

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extrae el token del header "Authorization"
        String token = extractTokenFromHeader(request);

        if (token != null) {
            // Extrae el nombre de usuario del token
            String username = jwtUtils.extractUsername(token);

            // Si el token es válido, configura la autenticación
            if (jwtUtils.validateToken(token, username)) {
                // Extrae los roles y permisos del token
                List<GrantedAuthority> authorities = jwtUtils.extractRoles(token);

                // Carga los detalles del usuario con los roles extraídos
                UserDetails userDetails = authService.loadUserByUsername(username);

                // Crea el objeto de autenticación con los roles y el usuario
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities);

                // Establece la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // Continua con el filtro
        filterChain.doFilter(request, response);
    }

    // Método para extraer el token desde el header
    private String extractTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // Extrae el token (sin "Bearer ")
        }
        return null;
    }

}
