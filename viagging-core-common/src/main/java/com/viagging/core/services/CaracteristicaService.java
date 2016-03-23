package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Caracteristica;
import com.viagging.rest.dto.AlojamientoDTO;


public interface CaracteristicaService {
     
	List<Caracteristica> getCaracteristicaByCategoria(String categoria);

}
