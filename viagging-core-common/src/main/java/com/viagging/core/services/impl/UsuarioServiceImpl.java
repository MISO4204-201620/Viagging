package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.AlimentacionService;
import com.viagging.core.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements  UsuarioService  {

	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		return usuarioDAO.getUsuarioById(idUsuario);
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		return usuarioDAO.createUsuario(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}
	
}
