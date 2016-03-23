package com.viagging.core.services;

import com.viagging.core.model.Usuario;


public interface UsuarioService {
     
	Usuario findUsuarioByLoginAndPassword(String login, String password);
	
	Usuario getUsuarioById(Integer idUsuario);

	Usuario createUsuario(Usuario usuario);

	Usuario updateUsuario(Usuario usuario);
	
}
