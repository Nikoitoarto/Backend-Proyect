package com.ProyectoFormulario.ProyectoFormulario.ControllerTest;


import com.ProyectoFormulario.ProyectoFormulario.Controller.UsuarioController;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.Service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class) // Usa la anotación adecuada para WebMvc

public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController; // Controlador que vamos a probar


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(usuarioController).build(); // Configuramos MockMvc
    }


    @Test
    public void testFindByStateTrue() throws Exception {
        // Crear lista de usuarios simulados
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("usuario1");
        usuarios.add(usuario1);

        // Simular el comportamiento del servicio
        when(usuarioService.findByStateTrue()).thenReturn(usuarios);

        // Realizar la petición GET y verificar la respuesta
        mvc.perform(get("/api/usuario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Verificar que la respuesta es 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].nombreUsuario").value("usuario1")) // Verificar el nombre del usuario
                .andExpect(jsonPath("$.message").value("Datos obtenidos"))
                .andExpect(jsonPath("$.status").value(true));
    }

}
