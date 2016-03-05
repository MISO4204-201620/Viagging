package com.viagging.core.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;

/**
 * The Class ModuloDAOImpl.
 */
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

}