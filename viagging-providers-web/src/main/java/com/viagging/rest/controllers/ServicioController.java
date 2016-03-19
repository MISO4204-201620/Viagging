package com.viagging.rest.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
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
		  System.out.println(servicioJSON.getImages()[0] + "...");
	  }
	  
	  @RequestMapping(value = "/guardarImagen", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void guardarImagen(@RequestBody String file) {
		  System.out.println("Guardando imagen--......" + file);
	  }
	  
	  
	  @RequestMapping(value = "/guardarImagen2", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void guardarImagen2(@RequestBody byte[] file) {
		  System.out.println("dddd");
//		  String encoded = Base64.encodeBase64URLSafeString(file);
//		  System.out.println("Guardando imagen--......" + encoded);
	  }
	  
	  @RequestMapping(value = "/obtenerCiudades", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<String> obtenerCiudades() {
		  List<String> ciudades = new ArrayList<String>();
		  ciudades.add("Bogota");
		  ciudades.add("Medellin");
		  ciudades.add("Cali");
		  ciudades.add("Manizales");
		  System.out.println("Retornando ciudades");
		  return ciudades;
	  }
	  
	  @RequestMapping(value = "/guardarAlojamiento", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void guardarAlojamiento(@RequestBody ServicioDTO servicioJSON) {
		  System.out.println("Guardando servicio");
		  System.out.println(servicioJSON.getNombre() + "...");
		  System.out.println(servicioJSON.getImages()[0] + "...");
	  }
	  
	  
}
