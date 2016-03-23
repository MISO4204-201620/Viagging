package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.AlojamientoDAO;
import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.AlojamientoService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.AlojamientoDTO;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

	@Autowired
	private AlojamientoDAO alojamientoDAO;
	
	@Autowired
	private ServicioService servicioService;
	
	@Override
	public Alojamiento getAlojamientoById(Integer idAlojamiento) {
		return alojamientoDAO.getAlojamientoById(idAlojamiento);
	}

	@Override
	public Alojamiento createAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.createAlojamiento(alojamiento);
	}

	@Override
	public Alojamiento updateAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.updateAlojamiento(alojamiento);
	}
	
	@Override
	public Alojamiento deleteAlojamiento(Integer idAlojamiento) {
		return alojamientoDAO.deleteAlojamiento(idAlojamiento);
	}
	
	public void createAlojamiento(AlojamientoDTO alojamientoDTO) {
		Alojamiento alojamiento = alojamientoDTOToModel(alojamientoDTO);
		createAlojamiento(alojamiento);
	}
	
	private Alojamiento alojamientoDTOToModel(AlojamientoDTO alojamientoDTO) {
		Alojamiento alojamiento = new Alojamiento();
		alojamiento.setCiudad(alojamientoDTO.getCiudad());
		alojamiento.setValorpornoche(Integer.parseInt(alojamientoDTO.getValorPorNoche()));
		Servicio servicio = servicioService.servicioDTOToModel(alojamientoDTO.getServicio());
		servicioService.createServicio(servicio);
		return alojamiento;
	}
}
