package com.viagging.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.viagging.core.services.AlojamientoService;
import com.viagging.rest.dto.AlojamientoDTO;

public class LodgingController {
	
	@Autowired
	private AlojamientoService lodgingService;
	
	@RequestMapping(value = "/saveLodging", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveLodging(@RequestBody AlojamientoDTO alojamiento) {
		lodgingService.createAlojamiento(alojamiento);
	}

}
