package com.viagging.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.model.Modulo;

@Component
public class ModuloDAOImpl implements ModuloDAO {

	@PersistenceContext	
	private EntityManager entityManager;

	@Transactional
	public void save(String nombre) {
		System.out.println("ModuloDAOImpl insert is called");
		String qlString = "insert into tp_modulo (nombre) values (?)";
		Query query = entityManager.createNativeQuery(qlString);		
		query.setParameter(1, nombre);
		int result = query.executeUpdate();
        System.out.println(result);
	}
    
	@SuppressWarnings("unchecked")
	public List<Modulo> getAll() {
		List<Modulo> listModulo = new ArrayList<Modulo>();		
		listModulo = entityManager.createNamedQuery("Modulo.findAll").getResultList();
		for (Modulo tpModulo : listModulo) {
			System.out.println(tpModulo.getId());
			System.out.println(tpModulo.getNombre());
		}		
		return listModulo;
	} 

	public Modulo getById(int id) {
		Modulo modulo = new Modulo();			
		Query query  = entityManager.createNamedQuery("Modulo.findById");
		query.setParameter("id", id);
		modulo = (Modulo) query.getSingleResult();
        System.out.println("modulooo"+modulo.getId());	
		return modulo;
	} 
}