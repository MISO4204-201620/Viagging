package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.constant.Profile;
import com.viagging.core.dao.CuentaAccesoDAO;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Usuario;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<CuentaAcceso> getUsersAdminProv(){
		 Query query = entityManager
		            .createQuery("SELECT t from CuentaAcceso t where t.perfil.id = :proveedor or t.perfil.id = :admin ");
		 query.setParameter("proveedor",Integer.valueOf(Profile.PROVEEDOR.getId()));
		 query.setParameter("admin", Integer.valueOf(Profile.ADMINISTRADOR.getId()));
				List<CuentaAcceso> listaCuentaAcceso =  query.getResultList(); 
		return listaCuentaAcceso;
				
	}
	
}