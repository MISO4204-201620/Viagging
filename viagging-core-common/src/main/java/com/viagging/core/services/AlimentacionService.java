package com.viagging.core.services;

import org.json.JSONException;

import com.viagging.core.model.Alimentacion;
import com.viagging.rest.dto.AlimentacionDTO;


public interface AlimentacionService {
     
	Alimentacion getAlimentacionById(Integer idAlimentacion);

	Alimentacion createAlimentacion(Alimentacion alimentacion);

	Alimentacion updateAlimentacion(Alimentacion alimentacion);
	
	Alimentacion deleteAlimentacion(Integer idAlimentacion);
	
	void createAlimentacion(AlimentacionDTO alojamiento) throws JSONException;
}
