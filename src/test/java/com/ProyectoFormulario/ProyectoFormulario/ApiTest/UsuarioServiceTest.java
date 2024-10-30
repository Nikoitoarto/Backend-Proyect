package com.ProyectoFormulario.ProyectoFormulario.ApiTest;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.Service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService; // Cambia a la implementación de UsuarioService

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private IRolRepository rolRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void testCrearUsuario_exito() throws Exception {
        // Crear datos simulados
        Persona persona = new Persona();
        persona.setId(1L);
        persona.setNombre("John");
        persona.setApellido("Doe");

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.getUsuario().setNombreUsuario("usuario1");
        usuarioDto.setPersonaId(1L);
        usuarioDto.setRolId(1L);

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setTipoRol(TipoRol.DOCENTE);

        // Simular las respuestas de los repositorios
        when(rolRepository.findById(1L)).thenReturn(Optional.of(rol));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(new Usuario());

        // Llamar al método de servicio
        ApiResponseDto<Usuario> response = usuarioService.crearUsuario(usuarioDto);

        // Verificar que el método save fue llamado
        verify(usuarioRepository, times(1)).save(any(Usuario.class));

        // Verificar que el rolRepository fue llamado
        verify(rolRepository, times(1)).findById(1L);

        // Verificar resultados
        assertTrue(response.getStatus());
        assertEquals("Usuario creado exitosamente", response.getMessage());
    }

    @Test
    public void testCrearUsuario_falla_rolNoEncontrado() {
        // Crear datos simulados
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.getUsuario().setNombreUsuario("usuario1");
        usuarioDto.setPersonaId(1L);
        usuarioDto.setRolId(99L); // ID de un rol inexistente

        // Simular que no se encuentra el rol en la base de datos
        when(rolRepository.findById(99L)).thenReturn(Optional.empty());

        // Llamar al método de servicio y capturar excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.crearUsuario(usuarioDto);
        });

        // Verificar mensaje de excepción
        Assertions.assertEquals("Rol no encontrado con ID: 99", exception.getMessage());

        // Verificar que el método save NO fue llamado
        verify(usuarioRepository, times(0)).save(any(Usuario.class));

        // Verificar que el rolRepository fue llamado
        verify(rolRepository, times(1)).findById(99L);
    }
}
