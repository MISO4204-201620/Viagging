package com.viagging.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.rest.dto.ServicioDTO;

@RestController
public class ServicioController {
	
	  @RequestMapping(value = "/guardarServicio", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void guardarServicio(@RequestBody ServicioDTO servicioJSON) {
		  System.out.println("Guardando servicio");
		  System.out.println(servicioJSON.getNombre() + "...");
	  }
}
