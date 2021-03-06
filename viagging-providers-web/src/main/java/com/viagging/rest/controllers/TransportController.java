package com.viagging.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.services.TransporteService;
import com.viagging.rest.dto.TransporteDTO;

@RestController
public class TransportController {
	
	@Autowired
	private TransporteService transportService;

	@RequestMapping(value = "/saveTransport", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public Integer saveTransport(@RequestBody TransporteDTO transporte) {
		return transportService.createTransporte(transporte);
	}
}
