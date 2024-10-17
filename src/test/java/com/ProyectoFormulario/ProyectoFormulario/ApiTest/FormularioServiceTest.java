package com.ProyectoFormulario.ProyectoFormulario.ApiTest;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Formulario;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IFormularioRepository;
import com.ProyectoFormulario.ProyectoFormulario.Service.FormularioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FormularioServiceTest {


    @Mock
    private IFormularioRepository formularioRepositoryMock; // Mock del repositorio

    @Mock
    private Usuario usuarioMock;

    @Mock
    private Persona personaMock;

    @Mock
    private Rol rolMock;

    @InjectMocks
    private FormularioService formularioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearFormularioExitoso() throws Exception {
        // Crear los datos del formulario
        Formulario formulario = new Formulario();

        // Configurar el mock del Usuario y la Persona asociada
        when(usuarioMock.getPersona()).thenReturn(personaMock);
        when(personaMock.getNombre()).thenReturn("Juan");
        when(personaMock.getApellido()).thenReturn("Pérez");

        // Simular que el usuario tiene el rol de DOCENTE
        when(usuarioMock.getRoles()).thenReturn(Set.of(rolMock));
        when(rolMock.getTipoRol()).thenReturn(TipoRol.DOCENTE);

        // Llamar al método a probar
        Formulario resultado = formularioService.crearFormulario(formulario, usuarioMock);

        // Verificar que se hayan asignado correctamente los valores

    }

    @Test
    void testCrearFormularioUsuarioSinPersona() {
        // Crear los datos del formulario
        Formulario formulario = new Formulario();

        // Simular que el usuario tiene el rol de DOCENTE
        when(usuarioMock.getRoles()).thenReturn(Set.of(rolMock));
        when(rolMock.getTipoRol()).thenReturn(TipoRol.DOCENTE);

        // Simular que el usuario no tiene asociada una Persona
        when(usuarioMock.getRoles()).thenReturn(Set.of(rolMock));
        when(usuarioMock.getPersona()).thenReturn(null);

        // Verificar que se lance una excepción
        Exception exception = assertThrows(Exception.class, () -> {
            formularioService.crearFormulario(formulario, usuarioMock);
        });

        // Verificar el mensaje de error
        assertEquals("El usuario no tiene asociada una persona.", exception.getMessage());
    }

    @Test
    void testCrearFormularioUsuarioSinRolDocente() {
        // Crear los datos del formulario
        Formulario formulario = new Formulario();

        when(usuarioMock.getPersona()).thenReturn(personaMock);
        when(personaMock.getNombre()).thenReturn("Juan");
        when(personaMock.getApellido()).thenReturn("Pérez");
        // Simular que el usuario no tiene el rol de DOCENTE
        when(usuarioMock.getRoles()).thenReturn(Set.of());

        // Verificar que se lance una excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            formularioService.crearFormulario(formulario, usuarioMock);
        });

        // Verificar el mensaje de error
        assertEquals("Rol de docente no encontrado", exception.getMessage());
    }
}
