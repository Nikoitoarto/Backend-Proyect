package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.*;
import com.ProyectoFormulario.ProyectoFormulario.Enum.EstadoFormulario;
import com.ProyectoFormulario.ProyectoFormulario.Enum.TipoRol;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IBaseRepository;
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
    protected IBaseRepository<Formulario, Long> getRepository() {
        return null;
    }


    @Override
    public void diligenciarFormulario(Formulario formulario, Usuario usuario, AsignaturaDocencia asignatura, Actividades actividad) throws Exception {
        if (usuario.getRoles().stream().anyMatch(p -> p.getTipoRol() == TipoRol.Docente)) {
            formulario.setEstado(EstadoFormulario.DILIGENCIADO);
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
            if (rol.getTipoRol() == TipoRol.DireccionPrograma) {
                formulario.setEstado(EstadoFormulario.REVISADO_POR_DIRECCION_PROGRAMA);
                return;
            } else if (rol.getTipoRol() == TipoRol.Decano) {
                formulario.setEstado(EstadoFormulario.REVISADO_POR_DECANO);
                return;
            }
        }
        throw new Exception("El usuario no tiene permisos para revisar el formulario.");
    }

    @Override
    public void procesarFormulario(Formulario formulario, Usuario usuario) throws Exception {
        for (Rol rol : usuario.getRoles()) {
            if (formulario.getEstado() == EstadoFormulario.DILIGENCIADO && rol.getTipoRol() == TipoRol.Decano) {
                revisarFormulario(formulario, usuario);
                formulario.setEstado(EstadoFormulario.LISTO_PARA_VICERRECTORIA);
                return;
            } else if (formulario.getEstado() == EstadoFormulario.LISTO_PARA_VICERRECTORIA && rol.getTipoRol() == TipoRol.Vicerrectoria) {
                formulario.setEstado(EstadoFormulario.APROBADO);
                return;
            }
        }
        throw new Exception("El usuario no tiene permisos para procesar el formulario en este estado.");
    }

}





