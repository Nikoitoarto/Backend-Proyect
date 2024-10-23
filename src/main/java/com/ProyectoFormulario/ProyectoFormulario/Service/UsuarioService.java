package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IPersonaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {

    @Override
    protected IBaseRepository<Usuario, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    // Método para crear un usuario utilizando ApiResponseDto
    public ApiResponseDto<Usuario> crearUsuario(Usuario usuario, Rol rol, Persona persona) throws Exception {

        // Obtener la entidad Rol por ID
        Rol rolEncontrado = rolRepository.findById(rol.getId())
                .orElseThrow(() -> new Exception("El Rol con ID " + rol.getId() + " no existe"));

        // Obtener la persona que está creando el usuario
        Persona personaEncontrado = personaRepository.findById(persona.getId())
                .orElseThrow(() -> new Exception("La persona con ID " + persona.getId() + " no existe"));

        // Crear un nuevo usuario y asignar los datos
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(usuario.getNombreUsuario());
        nuevoUsuario.setContrasena(usuario.getContrasena());

        // Crear un Set y agregar el rol recuperado
        Set<Rol> roles = new HashSet<>();
        roles.add(rolEncontrado); // Usar rol encontrado
        nuevoUsuario.setRoles(roles); // Establecer los roles en el usuario

        // Asociar la persona existente
        nuevoUsuario.setPersona(personaEncontrado); // Usar persona encontrada

        // Guardar el nuevo usuario en la base de datos
        Usuario usuarioGuardado = repository.save(nuevoUsuario);

        // Retornar la respuesta
        return new ApiResponseDto<>("Usuario creado exitosamente", usuarioGuardado, true);
    }


}
