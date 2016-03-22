package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.viagging.core.dao.CaracteristicaDAO;
import com.viagging.core.model.Caracteristica;

@Repository
public class CaracteristicaDAOImpl implements CaracteristicaDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Caracteristica> getCaracteristicaByCategoria(String categoria) {
		return (List<Caracteristica>) entityManager.createNamedQuery("Caracteristica.findByCategoria").setParameter("categoria", categoria).getResultList();
	}


}
