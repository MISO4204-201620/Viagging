package com.viagging.core.services;

import java.util.List;
import com.viagging.core.model.Paquete;

public interface PaqueteService {

	Paquete getPaqueteById(Integer idPaquete);

	List<Paquete> getAllPaquete();

	Paquete createPaquete(Paquete paquete);

	Paquete updatePaquete(Paquete paquete);

}
