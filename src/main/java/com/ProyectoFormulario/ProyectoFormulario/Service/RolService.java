package com.ProyectoFormulario.ProyectoFormulario.Service;


import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;
import com.ProyectoFormulario.ProyectoFormulario.IRepository.IAbaseRepository;

import com.ProyectoFormulario.ProyectoFormulario.IService.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService extends ABaseService<Rol> implements IRolService {


    @Autowired
    private IAbaseRepository<Rol, Long> repository; // Inyecta tu repositorio específico

    @Override
    protected IAbaseRepository<Rol, Long> getRepository() {
        return repository; // Retorna el repositorio correcto
    }
    @Override
    public Rol save(Rol entity) throws Exception {
        if (entity.getTipoRol() == null) {
            throw new Exception("El tipo de rol no puede ser nulo");
        }

        // Lógica adicional basada en el tipo de perfil
        switch (entity.getTipoRol()) {
            case Docente:
                // Lógica específica para Docente
                break;
            case Decano:
                // Lógica específica para Decano
                break;
            case Vicerrectoria:
                // Lógica específica para Vicerrectoría
                break;
            case DireccionPrograma:
                // Lógica específica para Director de Programa
                break;
            case AdministradorSistema:
                // Lógica específica para Administrador del Sistema
                break;
            default:
                throw new Exception("Tipo de perfil no válido");
        }

        return super.save(entity);
    }




}

