package com.ProyectoFormulario.ProyectoFormulario.IService;


import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.LoginResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Persona;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Rol;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;


public interface IUsuarioService extends IBaseService<Usuario> {
    ApiResponseDto<Usuario> crearUsuario(Usuario usuario, Rol rol, Persona persona)throws Exception;
    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception;
    ApiResponseDto<LoginResponseDto> login(String nombreUsuario, String contrasena) throws Exception;


}
