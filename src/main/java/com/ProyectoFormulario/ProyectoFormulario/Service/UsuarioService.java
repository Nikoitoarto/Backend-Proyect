package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

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

    public UsuarioService(IUsuarioRepository usuarioRepository, IRolRepository rolRepository) {
        this.repository = usuarioRepository;
        this.rolRepository = rolRepository;
    }


    // Método para crear un usuario utilizando ApiResponseDto
    public ApiResponseDto<Usuario> crearUsuario(ApiResponseDto<Usuario> usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDto.getData().getNombreUsuario());

        // Crear y asignar persona
        Persona persona = new Persona();
        persona.setNombre(usuarioDto.getData().getPersona().getNombre());
        persona.setApellido(usuarioDto.getData().getPersona().getApellido());
        usuario.setPersona(persona);

        // Obtener y asignar roles, lanzando excepción si no se encuentra
        Set<Rol> roles = new HashSet<>();
        for (Rol rolId : usuarioDto.getData().getRoles()) {
            Rol rolEntidad = rolRepository.findById(rolId.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado con ID: " + rolId.getId()));
            roles.add(rolEntidad);
        }
        usuario.setRoles(roles);

        // Guardar el usuario en la base de datos
        Usuario usuarioGuardado = repository.save(usuario);
        return new ApiResponseDto<>("Usuario creado exitosamente", usuarioGuardado, true);
     }
    }



