package com.viagging.core.services;

import java.util.List;

import org.json.JSONException;

import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.ServicioDTO;

public interface ServicioService {
	
	Servicio getServicioById(Integer idServicio);

	List<Servicio> getAllServicio();

	Servicio createServicio(Servicio servicio);

	Servicio updateServicio(Servicio servicio);
    
	Servicio servicioDTOToModel(ServicioDTO servicio) throws JSONException;
	
	List<Servicio> getAllServiciosByCategoria(String idCategoria);
	
	List<Servicio> buildListServices(List<ServicioDTO> listServiceDTO);
}
