package com.ProyectoFormulario.ProyectoFormulario.ApiTest;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@DataJpaTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

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
    public void testCrearUsuario_exito() {
        // Crear datos simulados
        Persona persona = new Persona();
        persona.setNombre("John");
        persona.setApellido("Doe");

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("usuario1");
        usuario.setPersona(persona);

        Rol rolDocente = new Rol();
        rolDocente.setId(1L); // Simula que el rol tiene ID 1
        rolDocente.setTipoRol(TipoRol.DOCENTE); // Enum de tipo de rol

        Set<Rol> roles = new HashSet<>();
        roles.add(rolDocente);

        usuario.setRoles(roles); // Asignar roles simulados al usuario

        ApiResponseDto<Usuario> usuarioDto = new ApiResponseDto<>("Usuario Creado", usuario, true);

        // Simular las respuestas de los repositorios
        when(rolRepository.findById(1L)).thenReturn(Optional.of(rolDocente));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Llamar al método de servicio
        ApiResponseDto<Usuario> response = usuarioService.crearUsuario(usuarioDto);

        // Verificar que el método save fue llamado
        verify(usuarioRepository, times(1)).save(any(Usuario.class));

        // Verificar que el rolRepository fue llamado
        verify(rolRepository, times(1)).findById(1L);

        // Verificar resultados
        assertTrue(response.getStatus());
        assertEquals("Usuario creado exitosamente", response.getMessage());
        assertNotNull(response.getData());
        assertEquals("usuario1", response.getData().getNombreUsuario());
        assertEquals("John", response.getData().getPersona().getNombre());
    }

    @Test
    public void testCrearUsuario_falla_rolNoEncontrado() {
        // Crear datos simulados
        Persona persona = new Persona();
        persona.setNombre("John");
        persona.setApellido("Doe");

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("usuario1");
        usuario.setPersona(persona);

        Rol rolNoExistente = new Rol();
        rolNoExistente.setId(99L);
        // ID de un rol inexistente

        Set<Rol> roles = new HashSet<>();
        roles.add(rolNoExistente);

        usuario.setRoles(roles); // Asignar roles simulados al usuario

        ApiResponseDto<Usuario> usuarioDto = new ApiResponseDto<>("Usuario Creado", usuario, true);

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


