package com.viagging.core.dao;

import java.util.List;
import com.viagging.core.model.Paquete;

/**
 * The Interface PaqueteDAO.
 */
public interface PaqueteDAO {


	Paquete getPaqueteById(Integer idPaquete);


	List<Paquete> getAllPaquetes();

	Paquete createPaquete(Paquete paquete);


	Paquete updatePaquete(Paquete paquete);


	Paquete deletePaquete(Integer idPaquete);


}
