package com.viagging.dao;

import java.util.List;
import com.viagging.model.TpModulo;
import org.springframework.stereotype.Component;

@Component
public interface TpModuloDAO {

	public void save(String nombre);
	
	public List<TpModulo> getAll();
	
	public TpModulo getById(int id);
}
