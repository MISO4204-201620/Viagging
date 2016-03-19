package com.viagging.core.services;

import com.viagging.core.model.PaseoEcologico;

public interface PaseoEcologicoService {

	PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico);

	PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico);

	PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico);
	
	PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico);
}
