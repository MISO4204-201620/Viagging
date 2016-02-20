package com.viagging.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.model.TbPerfil;

@Component
public class TpPerfilDAOImpl implements TpPerfilDAO {
    
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	@Transactional
	public TbPerfil save(String nombre) {
		TbPerfil tbPerfil = new TbPerfil();	
		tbPerfil.setNombre(nombre);
		entityManager.merge(tbPerfil);
        return tbPerfil;
	}
}

