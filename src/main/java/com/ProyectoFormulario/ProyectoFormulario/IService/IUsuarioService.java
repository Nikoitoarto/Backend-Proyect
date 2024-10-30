package com.ProyectoFormulario.ProyectoFormulario.IService;


import com.ProyectoFormulario.ProyectoFormulario.Dto.ApiResponseDto;
import com.ProyectoFormulario.ProyectoFormulario.Dto.UsuarioDto;
import com.ProyectoFormulario.ProyectoFormulario.Entity.Usuario;


public interface IUsuarioService extends IBaseService<Usuario> {
    ApiResponseDto<Usuario> crearUsuario(UsuarioDto usuarioDto) throws Exception;
    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception;


}
