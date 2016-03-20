package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

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

}
