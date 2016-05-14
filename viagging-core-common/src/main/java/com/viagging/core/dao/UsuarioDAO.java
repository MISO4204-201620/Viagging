package com.viagging.core.dao;

import com.viagging.core.model.Usuario;


public interface UsuarioDAO {
	
	Usuario findUsuarioByLoginAndPassword(String login, String password);

	Usuario getUsuarioById(Integer idUsuario);

	Usuario createUsuario(Usuario usuario);

	Usuario updateUsuario(Usuario usuario);
	
	Usuario findUsuarioByLogin(String login);
	
	Usuario findUsuarioByNumber(String numeroDocumento);
	
	Usuario findUsuarioByEmail(String email);
	
	void deleteUser(Integer idUser);
	
}

