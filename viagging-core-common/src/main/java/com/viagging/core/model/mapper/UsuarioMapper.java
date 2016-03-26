package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

	public Usuario mapObject(UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(usuarioDTO.getId()));
		return usuario;
	}
	
	public List<Usuario> mapObjectList(List<UsuarioDTO> usuariosDTO){
		List<Usuario> usuarios = new ArrayList<>();
		for(UsuarioDTO usuarioDTO : usuariosDTO)
			usuarios.add(mapObject(usuarioDTO));
		return usuarios;
		
	}
	
}
