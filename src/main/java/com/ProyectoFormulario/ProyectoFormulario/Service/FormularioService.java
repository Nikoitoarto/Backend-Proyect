package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.*;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IFormularioRepository;
import com.ProyectoFormulario.ProyectoFormulario.IService.IFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularioService extends ABaseService<Formulario> implements IFormularioService {


    @Autowired
    private IFormularioRepository formularioRepository;

    @Override
    public Formulario crearFormulario(Formulario formulario) {
        return formularioRepository.save(formulario);
    }

    @Override
    protected IAbaseRepository<Formulario, Long> getRepository() {
        return null;
    }


    @Override
    public void diligenciarFormulario(Formulario formulario, Usuario usuario, AsignaturaDocencia asignatura, Actividades actividad) throws Exception {
        if (usuario.getRoles().stream().anyMatch(p -> p.getTipoRol() == Rol.TipoRol.Docente)) {
            formulario.setEstado(Formulario.EstadoFormulario.DILIGENCIADO);
            formulario.addAsignatura(asignatura);
            formulario.addActividad(actividad);
            formularioRepository.save(formulario);
        } else {
            throw new Exception("El usuario no tiene permisos para diligenciar el formulario.");
        }
    }

    @Override
    public void revisarFormulario(Formulario formulario, Usuario usuario) throws Exception {
        for (Rol rol : usuario.getRoles()) {
            if (rol.getTipoRol() == Rol.TipoRol.DireccionPrograma) {
                formulario.setEstado(Formulario.EstadoFormulario.REVISADO_POR_DIRECCION_PROGRAMA);
                return;
            } else if (rol.getTipoRol() == Rol.TipoRol.Decano) {
                formulario.setEstado(Formulario.EstadoFormulario.REVISADO_POR_DECANO);
                return;
            }
        }
        throw new Exception("El usuario no tiene permisos para revisar el formulario.");
    }

    @Override
    public void procesarFormulario(Formulario formulario, Usuario usuario) throws Exception {
        for (Rol rol : usuario.getRoles()) {
            if (formulario.getEstado() == Formulario.EstadoFormulario.DILIGENCIADO && rol.getTipoRol() == Rol.TipoRol.Decano) {
                revisarFormulario(formulario, usuario);
                formulario.setEstado(Formulario.EstadoFormulario.LISTO_PARA_VICERRECTORIA);
                return;
            } else if (formulario.getEstado() == Formulario.EstadoFormulario.LISTO_PARA_VICERRECTORIA && rol.getTipoRol() == Rol.TipoRol.Vicerrectoria) {
                formulario.setEstado(Formulario.EstadoFormulario.APROBADO);
                return;
            }
        }
        throw new Exception("El usuario no tiene permisos para procesar el formulario en este estado.");
    }

}





