package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Caracteristica;


public interface CaracteristicaDAO {

	List<Caracteristica> getCaracteristicaByCategoria(String categoria);

}
