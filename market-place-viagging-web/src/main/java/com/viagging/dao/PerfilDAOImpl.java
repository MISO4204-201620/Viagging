package com.viagging.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.model.Perfil;

@Component
public class PerfilDAOImpl implements PerfilDAO {
    
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	@Transactional
	public Perfil save(String nombre) {
		Perfil tbPerfil = new Perfil();	
		tbPerfil.setNombre(nombre);
		entityManager.merge(tbPerfil);
        return tbPerfil;
	}
}

