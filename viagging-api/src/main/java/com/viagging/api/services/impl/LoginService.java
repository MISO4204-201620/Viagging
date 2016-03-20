package com.viagging.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.api.services.ILoginService;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Usuario;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario getUserDetails(String login, String password) {
		return usuarioDAO.findUsuarioByLoginAndPassword(login, password);
	}

}
