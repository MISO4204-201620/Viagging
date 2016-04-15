package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.constant.EstadoItem;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
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
		entityManager.merge(usuario);
		return usuario;
	}
	
	@Override
	public Usuario findUsuarioByLogin(String login) {
		try {
			Query query = entityManager.createNamedQuery("Usuario.findLogin");
			query.setParameter("login", login);
			return (Usuario) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public Usuario findUsuarioByNumber(String numeroDocumento) {
		try {
			Query query = entityManager.createNamedQuery("Usuario.findNumberDocument");
			query.setParameter("numeroDocumento", numeroDocumento);
			return (Usuario) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public void deleteUser(Integer idUser){
		Usuario _user = entityManager.find(Usuario.class, idUser);
		if (_user != null) {
			_user.setEstado(EstadoItem.ELIMINADO.getId());
			entityManager.persist(_user);
		}
	}
	

	
}