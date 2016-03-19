package com.viagging.core.services;

import com.viagging.core.model.Transporte;

public interface TransporteService {

	Transporte getTransporteById(Integer idTransporte);

	Transporte createTransporte(Transporte transporte);

	Transporte updateTransporte(Transporte transporte);
	
	Transporte deleteTransporte(Integer idTransporte);
}
