package com.viagging.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

	
	@Autowired
	private ServicioDAO servicioDAO;

	@Override
	public Servicio getServicioById(Integer idServicio) {
		return servicioDAO.getServicioById(idServicio);
	}

	@Override
	public List<Servicio> getAllServicio() {
		return servicioDAO.getAllServicios();
	}

	@Override
	public Servicio createServicio(Servicio servicio) {
		return servicioDAO.createServicio(servicio);
	}

	@Override
	public Servicio updateServicio(Servicio servicio) {
		return servicioDAO.updateServicio(servicio);
	}

}
