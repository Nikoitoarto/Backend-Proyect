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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.List;

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
            // Extrae el nombre de usuario
            String username = jwtUtils.extractUsername(token);

            // Si el token es válido, configura la autenticación
            if (jwtUtils.validateToken(token, username)) {
                // Extrae los roles y permisos del token
                Long usuarioId = jwtUtils.extractUsuarioId(token);
                System.out.println("Usuario ID extraído del JWT: " + usuarioId);
                request.setAttribute("usuarioId", usuarioId);
                List<GrantedAuthority> authorities = jwtUtils.extractRoles(token);

                // Carga los detalles del usuario con los roles extraídos
                UserDetails userDetails = authService.loadUserByUsername(username);

                // Aquí, si lo deseas, puedes pasar el usuarioId a los detalles del usuario o al contexto
                // Puedes guardarlo en el SecurityContextHolder o en el Authentication
                // Esto depende de si necesitas usarlo más adelante
                // Ejemplo de agregar al contexto de seguridad:
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities));

                // O también puedes almacenar el usuarioId directamente en el contexto:
                request.setAttribute("usuarioId", usuarioId); // O usar otro mecanismo como el SecurityContext
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
