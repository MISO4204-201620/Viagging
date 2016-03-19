package com.viagging.core.services;

import com.viagging.core.model.Alimentacion;


public interface AlimentacionService {
     
	Alimentacion getAlimentacionById(Integer idAlimentacion);

	Alimentacion createAlimentacion(Alimentacion alimentacion);

	Alimentacion updateAlimentacion(Alimentacion alimentacion);
	
	Alimentacion deleteAlimentacion(Integer idAlimentacion);
}
