package com.viagging.core.dao;

import java.util.List;
import com.viagging.core.model.Servicio;

/**
 * The Interface ModuloDAO.
 */
public interface ServicioDAO {


	Servicio getServicioById(Integer idServicio);

	List<Servicio> getAllServicios();

	Servicio createServicio(Servicio servicio);

	Servicio updateServicio(Servicio servicio);

	Servicio deleteServicio(Integer idServicio);


}
