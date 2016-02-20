package com.viagging.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.model.TpModulo;

@Component
public class TpModuloDAOImpl implements TpModuloDAO {

	@PersistenceContext	
	private EntityManager entityManager;

	@Transactional
	public void save(String nombre) {
		System.out.println("TpModuloDAOImpl insert is called");
		String qlString = "insert into tp_modulo (nombre) values (?)";
		Query query = entityManager.createNativeQuery(qlString);		
		query.setParameter(1, nombre);
		int result = query.executeUpdate();
        System.out.println(result);
	}
    
	@SuppressWarnings("unchecked")
	public List<TpModulo> getAll() {
		List<TpModulo> listModulo = new ArrayList<TpModulo>();		
		listModulo = entityManager.createNamedQuery("TpModulo.findAll").getResultList();
		for (TpModulo tpModulo : listModulo) {
			System.out.println(tpModulo.getId());
			System.out.println(tpModulo.getNombre());
		}		
		return listModulo;
	} 

	public TpModulo getById(int id) {
		TpModulo modulo = new TpModulo();			
		Query query  = entityManager.createNamedQuery("TpModulo.findById");
		query.setParameter("id", id);
		modulo = (TpModulo) query.getSingleResult();
        System.out.println("modulooo"+modulo.getId());	
		return modulo;
	} 
}