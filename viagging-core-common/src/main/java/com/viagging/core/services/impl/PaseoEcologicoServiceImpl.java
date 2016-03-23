package com.viagging.core.services.impl;


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
	public void createPaseoEcologico(PaseoEcologicoDTO paseoEcologicoDTO) {
		PaseoEcologico paseoEcologico = buildPaseoEcologico(paseoEcologicoDTO);
		createPaseoEcologico(paseoEcologico);
	}
	
	private PaseoEcologico buildPaseoEcologico(PaseoEcologicoDTO paseoEcologicoDTO) {
		PaseoEcologico paseoEcologico = new PaseoEcologico();
		paseoEcologico.setCiudad(paseoEcologicoDTO.getCiudad());
		paseoEcologico.setHorario(paseoEcologicoDTO.getHorario());
		paseoEcologico.setTiempoderecorrido(paseoEcologicoDTO.getTiempoDeRecorrido());
		Servicio servicio = servicioService.buildServicio(paseoEcologicoDTO.getServicio());
		servicioService.createServicio(servicio);
		return paseoEcologico;
	}
	
}
