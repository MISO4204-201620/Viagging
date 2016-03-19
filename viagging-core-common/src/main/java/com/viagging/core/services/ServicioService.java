package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Servicio;

public interface ServicioService {
	
	Servicio getServicioById(Integer idServicio);

	List<Servicio> getAllServicio();

	Servicio createServicio(Servicio servicio);

	Servicio updateServicio(Servicio servicio);
    
	List<Servicio> getAllServiciosByCategoria(Integer idCategoria);
}
