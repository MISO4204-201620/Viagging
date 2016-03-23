package com.viagging.core.services.impl;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.dao.TransporteDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Transporte;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.TransporteService;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.TransporteDTO;

@Service
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteDAO transporteDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
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
	public void createTransporte(TransporteDTO transporteDTO) throws JSONException {
		Transporte transporte = transporteDTOToModel(transporteDTO);
		createTransporte(transporte);
		
	}
	
	private Transporte transporteDTOToModel(TransporteDTO transporteDTO) throws JSONException {
		Transporte transporte = new Transporte();
		transporte.setFrecuenciasalida(transporteDTO.getFrecuenciaSalida());
		transporte.setHorariofin(transporteDTO.getHorarioFin());
		transporte.setHorarioinicio(transporteDTO.getHorarioInicio());
		transporte.setLugardestino(transporteDTO.getLugarDestino());
		transporte.setLugarorigen(transporteDTO.getLugarOrigen());
		transporte.setTiempoestimado(transporteDTO.getTiempoEstimado());
		transporte.setTipotransporte(transporteDTO.getTipoTransporte());
		Servicio servicio = servicioDTOToModel(transporteDTO.getServicio());
		servicioDAO.createServicio(servicio);
		return transporte;
	}
	
	private Servicio servicioDTOToModel(ServicioDTO servicioDTO) {
		Servicio servicio = new Servicio();
		servicio.setActivo(true);
		Usuario usuario = usuarioDAO.getUsuarioById(1);
		servicio.setUsuario(usuario);
		servicio.setDescripcion(servicioDTO.getDescripcionCorta());
		servicio.setNombre(servicioDTO.getNombre());
		return servicio;
		
	}
	
}
