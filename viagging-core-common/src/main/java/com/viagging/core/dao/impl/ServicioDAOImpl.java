package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.ServicioDTO;

/**
 * The Class ServicioDAOImpl.
 */
@Transactional
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
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllServiciosTransporte(){
		return (List<Servicio>) entityManager.createNamedQuery("Servicio.findAllTransporte").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllServiciosAlojamiento(){
		return (List<Servicio>) entityManager.createNamedQuery("Servicio.findAllAlojamiento").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllServiciosAlimentacion(){
		return (List<Servicio>) entityManager.createNamedQuery("Servicio.findAllAlimentacion").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllServiciosPaseoEcologico(){
		return (List<Servicio>) entityManager.createNamedQuery("Servicio.findAllPaseoEcologico").getResultList();
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
		_servicio.setImagenprincipal(servicio.getImagenprincipal());
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


	@Override
	public Servicio servicioDTOToModel(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Servicio> findAllByCriteria(Servicio servicio){
		Query query = entityManager.createNamedQuery("Servicio.findAllByCriteria");
		query.setParameter("nombre", "%"+servicio.getNombre()+"%");
		query.setParameter("descripcion", "%"+servicio.getDescripcion()+"%");
		return (List<Servicio>) query.getResultList();
	}

}