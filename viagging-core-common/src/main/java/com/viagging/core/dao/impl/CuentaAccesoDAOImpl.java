package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.viagging.core.dao.CuentaAccesoDAO;
import com.viagging.core.model.CuentaAcceso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Repository
public class CuentaAccesoDAOImpl implements CuentaAccesoDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaAccesoDAOImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
    
	@Override
	public CuentaAcceso createCuentaAcceso(CuentaAcceso cuentaAcceso){
		entityManager.persist(cuentaAcceso);
		return cuentaAcceso;
	}


	
}