package com.viagging.rest.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.services.PaseoEcologicoService;
import com.viagging.rest.dto.PaseoEcologicoDTO;

@RestController
public class TravelController {
	
	@Autowired
	private PaseoEcologicoService travelService;

	@RequestMapping(value = "/saveTravel", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveTravel(@RequestBody PaseoEcologicoDTO paseo) throws JSONException {
		travelService.createPaseoEcologico(paseo);
	}
}
