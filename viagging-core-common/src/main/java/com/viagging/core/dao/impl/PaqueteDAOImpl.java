package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;

/**
 * The Class ModuloDAOImpl.
 */
@Transactional
@Repository
public class PaqueteDAOImpl implements PaqueteDAO {


	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Paquete getPaqueteById(Integer idPaquete){
		return entityManager.find(Paquete.class, idPaquete);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Paquete> getAllPaquetes() {
		return (List<Paquete>) entityManager.createNamedQuery("Paquete.findAll").getResultList();
	}


	@Override
	public Paquete createPaquete(Paquete paquete){
		entityManager.persist(paquete);
		return paquete;
	}


	@Override
	public Paquete updatePaquete(Paquete paquete) {
		Paquete _paquete = entityManager.find(Paquete.class, paquete.getId());
		_paquete.setNombrePaquete(paquete.getNombrePaquete());
		entityManager.persist(_paquete);
		return _paquete;
	}


	@Override
	public Paquete deletePaquete(Integer idPaquete){
		Paquete paquete = entityManager.find(Paquete.class, idPaquete);
		if (paquete != null) {
			entityManager.remove(paquete);
		}
		return paquete;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paquete> getAllPaquetesByFiltro(String filtro){
		if(filtro == null){
			filtro = "";
		}
		 Query query = entityManager
		            .createQuery("SELECT t from Paquete t where t.nombrePaquete LIKE :filtro");
		        query.setParameter("filtro", "%"+filtro+"%");
		        
				List<Paquete> listaPaquete =  query.getResultList(); 
		return listaPaquete;
				
	}

}