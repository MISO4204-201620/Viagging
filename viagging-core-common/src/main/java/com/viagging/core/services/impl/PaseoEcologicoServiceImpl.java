package com.viagging.core.services.impl;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PaseoEcologicoDAO;
import com.viagging.core.model.PaseoEcologico;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.PaseoEcologicoService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.PaseoEcologicoDTO;

@Service
public class PaseoEcologicoServiceImpl implements PaseoEcologicoService {

	@Autowired
	private PaseoEcologicoDAO paseoEcologicoDAO;
	
	@Autowired
	private ServicioService servicioService;
	
	@Override
	public PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico) {
		return paseoEcologicoDAO.getPaseoEcologicoById(idPaseoEcologico);
	}

	@Override
	public PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico) {
		return paseoEcologicoDAO.createPaseoEcologico(paseoEcologico);
	}

	@Override
	public 	PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico){
		return paseoEcologicoDAO.updatePaseoEcologico(paseoEcologico);
	}
	
	@Override
	public PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico) {
		return paseoEcologicoDAO.deletePaseoEcologico(idPaseoEcologico);
	}

	@Override
	public void createPaseoEcologico(PaseoEcologicoDTO paseoEcologicoDTO) throws JSONException {
		PaseoEcologico paseoEcologico = paseoEcologicoDTOToModel(paseoEcologicoDTO);
		createPaseoEcologico(paseoEcologico);
	}
	
	private PaseoEcologico paseoEcologicoDTOToModel(PaseoEcologicoDTO paseoEcologicoDTO) throws JSONException {
		JSONObject jsonObj = new JSONObject(paseoEcologicoDTO.getCaracteristicas());
		Iterator<String> keys = jsonObj.keys();
		String caracteristicas = "";
		while (keys.hasNext()) {
			String key = keys.next();
			boolean isActive = jsonObj.getBoolean(key);
			if (isActive) {
				caracteristicas += key;
			}
		}
		PaseoEcologico paseoEcologico = new PaseoEcologico();
		paseoEcologico.setCiudad(paseoEcologicoDTO.getCiudad());
		paseoEcologico.setHorario(paseoEcologicoDTO.getHorario());
		paseoEcologico.setRestricciones(paseoEcologicoDTO.getRestricciones());
		paseoEcologico.setTiempoderecorrido(paseoEcologicoDTO.getTiempoDeRecorrido());
		paseoEcologico.setCaracteristicas(caracteristicas);
		Servicio servicio = servicioService.servicioDTOToModel(paseoEcologicoDTO.getServicio());
		servicioService.createServicio(servicio);
		return paseoEcologico;
	}
	
}
