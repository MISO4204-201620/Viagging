package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Usuario;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

    
	@Override
	public Usuario findUsuarioByLoginAndPassword(String login, String password) {
		try {
			Query query = entityManager.createNamedQuery("Usuario.findByPasswordAndLogin");
			query.setParameter("login", login);
			query.setParameter("password", password);
			return (Usuario) query.getSingleResult();
		} catch(NoResultException e){
			LOGGER.error(e.getMessage());
			return null;
		}
	}
	
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
