package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.TransporteDAO;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Transporte;
import com.viagging.core.services.ServicioService;
import com.viagging.core.services.TransporteService;
import com.viagging.rest.dto.TransporteDTO;

@Service
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteDAO transporteDAO;

	@Autowired
	private ServicioService servicioService;
	
	@Override
	public Transporte getTransporteById(Integer idTransporte) {
		return transporteDAO.getTransporteById(idTransporte);
	}

	@Override
	public Transporte createTransporte(Transporte transporte) {
		return transporteDAO.createTransporte(transporte);
	}

	@Override
	public 	Transporte updateTransporte(Transporte transporte){
		return transporteDAO.updateTransporte(transporte);
	}
	
	@Override
	public Transporte deleteTransporte(Integer idTransporte) {
		return transporteDAO.deleteTransporte(idTransporte);
	}

	@Override
	public void createTransporte(TransporteDTO transporteDTO) {
		Transporte transporte = buildTransporte(transporteDTO);
		createTransporte(transporte);
		
	}
	
	private Transporte buildTransporte(TransporteDTO transporteDTO) {
		Transporte transporte = new Transporte();
		transporte.setFrecuenciasalida(transporteDTO.getFrecuenciaSalida());
		transporte.setHorariofin(transporteDTO.getHorarioFin());
		transporte.setHorarioinicio(transporteDTO.getHorarioInicio());
		transporte.setLugardestino(transporteDTO.getLugarDestino());
		transporte.setLugarorigen(transporteDTO.getLugarOrigen());
		transporte.setTiempoestimado(transporteDTO.getTiempoEstimado());
		transporte.setTipotransporte(transporteDTO.getTipoTransporte());
		Servicio servicio = servicioService.buildServicio(transporteDTO.getServicio());
		servicioService.createServicio(servicio);
		return transporte;
	}

}
