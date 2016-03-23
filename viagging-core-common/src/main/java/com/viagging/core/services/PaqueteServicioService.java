package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Paquete;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.PaqueteDTO;

public interface PaqueteServicioService {

	List<PaqueteServicio> getPaqueteServicioByIdPaquete(String idPaquete);


}
