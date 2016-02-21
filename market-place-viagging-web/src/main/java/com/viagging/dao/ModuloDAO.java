package com.viagging.dao;

import java.util.List;
import com.viagging.model.Modulo;
import org.springframework.stereotype.Component;

@Component
public interface ModuloDAO {

	public void save(String nombre);
	
	public List<Modulo> getAll();
	
	public Modulo getById(int id);
}
