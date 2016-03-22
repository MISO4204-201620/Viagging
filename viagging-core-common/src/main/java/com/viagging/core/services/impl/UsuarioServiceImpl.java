package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.UsuarioService;

/**
 * The Class UsuarioServiceImpl.
 */
@Service
public class UsuarioServiceImpl implements  UsuarioService  {

	/** The usuario dao. */
	@Autowired
	private UsuarioDAO usuarioDAO;

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#findUsuarioByLoginAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario findUsuarioByLoginAndPassword(String login, String password){
		return usuarioDAO.findUsuarioByLoginAndPassword(login, password);
	};
	
	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#getUsuarioById(java.lang.Integer)
	 */
	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		return usuarioDAO.getUsuarioById(idUsuario);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#createUsuario(com.viagging.core.model.Usuario)
	 */
	@Override
	public Usuario createUsuario(Usuario usuario) {
		return usuarioDAO.createUsuario(usuario);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.services.UsuarioService#updateUsuario(com.viagging.core.model.Usuario)
	 */
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}
	
}
