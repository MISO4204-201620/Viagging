package com.viagging.rest.dto.mapper;

import org.springframework.stereotype.Component;

import com.viagging.core.model.PaseoEcologico;
import com.viagging.rest.dto.PaseoEcologicoDTO;

@Component
public class PaseoEcologicoDTOMapper {

	public PaseoEcologicoDTO mapObject(PaseoEcologico paseoEcologico){		
		PaseoEcologicoDTO paseoEcologicoDTO = new PaseoEcologicoDTO();
		return paseoEcologicoDTO;
	}
	
}
