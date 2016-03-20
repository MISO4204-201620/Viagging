package com.viagging.core.dao;

import com.viagging.core.model.Usuario;

public interface UsuarioDAO {

	Usuario findUsuarioByLoginAndPassword(String login, String password);
	
}
