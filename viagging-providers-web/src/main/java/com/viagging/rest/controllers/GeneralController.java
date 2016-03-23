package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Caracteristica;
import com.viagging.core.services.CaracteristicaService;
import com.viagging.rest.dto.ImagenDTO;

@RestController
public class GeneralController {
	
	@Autowired
	private CaracteristicaService caracteristicaService;
	
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

	@RequestMapping(value = "/obtenerCaracteristicas", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> obtenerCaracteristicas(@QueryParam("categoria") String categoria) {
		List<Caracteristica> caracteristicas = caracteristicaService.getCaracteristicaByCategoria(categoria);
		List<String> cs = new ArrayList<String>();
		for (Caracteristica caracteristica : caracteristicas) {
			cs.add(caracteristica.getValor());
		}
		return cs;
	}
	
	@RequestMapping(value = "/guardarImagen3", method = RequestMethod.PUT)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public void guardarImagen3(@RequestBody String file, @QueryParam("idservicio") String idservicio) {
		System.out.println("------------" + idservicio);
		System.out.println(file);
		//		  String encoded = Base64.encodeBase64URLSafeString(files);
		//		  System.out.println("Guardando imagen--......" + encoded);
	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveImage(@RequestBody List<String> files) {
		System.out.println("********");
		System.out.println(files);
		//		  String encoded = Base64.encodeBase64URLSafeString(files);
		//		  System.out.println("Guardando imagen--......" + encoded);
	}

}
