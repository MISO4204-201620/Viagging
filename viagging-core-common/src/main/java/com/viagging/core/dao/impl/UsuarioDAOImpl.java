package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		return entityManager.find(Usuario.class, idUsuario);
	}


	@Override
	public Usuario createUsuario(Usuario usuario){
		entityManager.persist(usuario);
		return usuario;
	}


	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Usuario _usuario = entityManager.find(Usuario.class, usuario.getId());
		_usuario.setCorreo(_usuario.getCorreo());
		entityManager.persist(_usuario);
		return _usuario;
	}

}