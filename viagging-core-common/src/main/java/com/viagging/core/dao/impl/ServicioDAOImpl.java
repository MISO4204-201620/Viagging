package com.viagging.core.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.Servicio;

/**
 * The Class ModuloDAOImpl.
 */
@Repository
public class ServicioDAOImpl implements ServicioDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Servicio getServicioById(Integer idServicio) {
		return entityManager.find(Servicio.class, idServicio);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllServicios() {
		return (List<Servicio>) entityManager.createNamedQuery("Servicio.findAll").getResultList();
	}


	@Override
	public Servicio createServicio(Servicio servicio){
		entityManager.persist(servicio);
		return servicio;
	}


	@Override
	public Servicio updateServicio(Servicio servicio) {
		Servicio _servicio = entityManager.find(Servicio.class, servicio.getId());
		_servicio.setNombre(servicio.getNombre());
		entityManager.persist(_servicio);
		return _servicio;
	}


	@Override
	public Servicio deleteServicio(Integer idServicio){
		Servicio servicio = entityManager.find(Servicio.class, idServicio);
		if (servicio != null) {
			entityManager.remove(servicio);
		}
		return servicio;
	}

}