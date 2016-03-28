package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

	public Usuario mapObject(UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		if(!StringUtils.isEmpty(usuarioDTO.getId())){
			usuario.setId(Integer.valueOf(usuarioDTO.getId()));
		}
		usuario.setPrimerNombre(usuarioDTO.getPrimerNombre());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setPrimerApellido(usuarioDTO.getPrimerApellido());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(usuarioDTO.getPassword());
		return usuario;
	}
	
	public List<Usuario> mapObjectList(List<UsuarioDTO> usuariosDTO){
		List<Usuario> usuarios = new ArrayList<>();
		for(UsuarioDTO usuarioDTO : usuariosDTO)
			usuarios.add(mapObject(usuarioDTO));
		return usuarios;
		
	}
	
}
