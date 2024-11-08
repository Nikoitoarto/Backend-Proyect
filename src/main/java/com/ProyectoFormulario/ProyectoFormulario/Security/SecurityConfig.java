package com.ProyectoFormulario.ProyectoFormulario.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthService authService;

    public SecurityConfig(@Lazy AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Deshabilitar CSRF (esto es común cuando se usa JWT)
        http.csrf(csrf -> csrf.disable())
                // Configurar CORS (asegurarse de que la configuración de CORS esté lista)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Configuración de autorización
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // Permitir acceso sin autenticación a las rutas públicas
                                .requestMatchers("/api/auth/login", "/api/usuario/**", "/api/permiso/**",
                                        "/api/rol/**", "/api/persona/**", "/v3/api-docs/**",
                                        "/swagger-ui/**", "/swagger-ui.html", "/swagger-resources/**")
                                .permitAll()
                                // Rutas protegidas por permisos específicos
                                .requestMatchers("/proyectoformulario/api/formulario/crear")
                                .hasAuthority("acceso:formulario")

                                .requestMatchers("/api/revisionFormulario")
                                .hasAuthority("acceso:revisar")

                                .requestMatchers("/api/auditoriaFormulario")
                                .hasAuthority("acceso:revisar")

                                .requestMatchers("/api/asignatura_docencia")
                                .hasAuthority("acceso:formulario")

                                .requestMatchers("/api/actividades_labores")
                                .hasAuthority("acceso:formulario")

                                .requestMatchers("/api/actividades_docencia")
                                .hasAuthority("acceso:formulario")

                                .requestMatchers("/api/actividades_cientificas")
                                .hasAuthority("acceso:formulario")

                                .requestMatchers("/api/actividades_administrativa")
                                .hasAuthority("acceso:formulario")
                                .anyRequest().authenticated()
                );
        // Asegurarse de agregar el filtro JWT antes del filtro de autenticación por defecto
        http.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    // Filtro JWT (asegúrate de tener un filtro configurado para procesar el JWT)
    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter(); // Define tu filtro de JWT
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(authService) // Usa tu servicio de autenticación
                .passwordEncoder(passwordEncoder()); // Configura el codificador de contraseñas
        return authenticationManagerBuilder.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:9080", "http://localhost:3000"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
