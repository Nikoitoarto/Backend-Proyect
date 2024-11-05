package com.ProyectoFormulario.ProyectoFormulario.Service;

import com.ProyectoFormulario.ProyectoFormulario.Entity.Permiso;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Enum.NombrePermiso;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IPermisoRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IRolRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IPermisoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class PermisoService extends ABaseService<Permiso> implements IPermisoService {


    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IPermisoRepository repository; // Inyecta tu repositorio específico

    @Override
    protected IBaseRepository<Permiso, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }


    // Método para inicializar roles y permisos en la base de datos
    @PostConstruct
    public void inicializarRolesYPermisos() {
        // Asigna permisos a roles según el caso
        asignarPermisosARoles(TipoRol.ADMIN, NombrePermiso.values()); // ADMIN tiene todos los permisos
        asignarPermisosARoles(TipoRol.DOCENTE, NombrePermiso.ACCESO_FORMULARIOCREAR, NombrePermiso.ACCESO_FORMULARIOEDITAR); // Ejemplo para USUARIO
        asignarPermisosARoles(TipoRol.DECANO, NombrePermiso.ACCESO_REVISAR); // Ejemplo para REVISOR
        asignarPermisosARoles(TipoRol.VICERRECTORIA, NombrePermiso.ACCESO_REVISAR); // Ejemplo para REVISOR
        asignarPermisosARoles(TipoRol.DIRECCIONPROGRAMA, NombrePermiso.ACCESO_REVISAR); // Ejemplo para REVISOR

    }

    private void asignarPermisosARoles(TipoRol tipoRol, NombrePermiso... permisos) {
        // Buscar o crear el rol
        Rol rol = rolRepository.findByTipoRol(tipoRol)
                .orElseGet(() -> rolRepository.save(new Rol(tipoRol)));

        // Asignar cada permiso al rol
        Arrays.stream(permisos).forEach(nombrePermiso -> {
            // Buscar o crear el permiso
            Permiso permiso = repository.findByNombrePermiso(nombrePermiso)
                    .orElseGet(() -> repository.save(new Permiso(nombrePermiso)));

            // Asignar permiso al rol si no está ya presente
            if (!rol.getPermisos().contains(permiso)) {
                rol.addPermiso(permiso);
            }
        });
        // Guardar cambios en el rol
        rolRepository.save(rol);
    }

}

