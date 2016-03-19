package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PaseoEcologicoDAO;
import com.viagging.core.model.PaseoEcologico;
import com.viagging.core.services.PaseoEcologicoService;

@Service
public class PaseoEcologicoServiceImpl implements PaseoEcologicoService {

	@Autowired
	private PaseoEcologicoDAO paseoEcologicoDAO;

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
}