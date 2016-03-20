package com.viagging.core.dao;

import com.viagging.core.model.Usuario;


public interface UsuarioDAO {

	Usuario getUsuarioById(Integer idUsuario);

	Usuario createUsuario(Usuario usuario);

	Usuario updateUsuario(Usuario usuario);
	
}
