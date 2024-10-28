package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IPersonaRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IUsuarioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IUsuarioService;
import com.ProyectoFormulario.ProyectoFormulario.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {

    @Override
    protected IBaseRepository<Usuario, Long> getRepository() {
        return repository;
    }

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IPersonaRepository personaRepository;

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

        // Hashear la contraseña antes de asignarla
        String hashedPassword = passwordEncoder.encode(usuario.getContrasena());
        nuevoUsuario.setContrasena(hashedPassword);

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


    @Override
    public ApiResponseDto<LoginResponseDto> login(String nombreUsuario, String contrasena) throws Exception {
        Usuario usuario = repository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        if (!passwordEncoder.matches(contrasena, usuario.getContrasena())) {
            throw new Exception("Contraseña incorrecta");
        }

        String token = jwtUtils.generateToken(nombreUsuario);

        LoginResponseDto loginResponse = new LoginResponseDto(
                token,
                usuario.getNombreUsuario(),
                usuario.getPersona().getId(),
                usuario.getRoles().iterator().next().getId()
        );

        return new ApiResponseDto<>("Login exitoso", loginResponse, true);
    }



    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception {
        Optional<Usuario> usuarioOptional = repository.findByNombreUsuario(nombreUsuario);
        if (usuarioOptional.isPresent()) {
            System.out.println("Usuario encontrado: " + usuarioOptional.get()); // Debug log
            return usuarioOptional.get();
        } else {
            throw new Exception("Usuario con nombre " + nombreUsuario + " no encontrado");
        }
    }



}
