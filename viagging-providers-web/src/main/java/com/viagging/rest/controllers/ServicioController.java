package com.viagging.rest.controllers;

//import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.Caracteristica;
import com.viagging.core.services.AlojamientoService;
import com.viagging.core.services.CaracteristicaService;
import com.viagging.rest.dto.AlojamientoDTO;
import com.viagging.rest.dto.File;
import com.viagging.rest.dto.ImagenDTO;
import com.viagging.rest.dto.ServicioDTO;

public class ServicioController {

	@Autowired
	private CaracteristicaService caracteristicaService;
	
	@Autowired
	private AlojamientoService alojamientoService;

	@RequestMapping(value = "/guardarServicio", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void guardarServicio(@RequestBody ServicioDTO servicioJSON) {
		System.out.println("Guardando servicio");
		System.out.println(servicioJSON.getNombre() + "...");
	}

	@RequestMapping(value = "/guardarImagen", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void guardarImagen(@RequestBody String file) {
		System.out.println("Guardando imagen--......" + file);
	}


	@RequestMapping(value = "/guardarImagen2", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void guardarImagen2(@RequestBody List<File> files) {
		System.out.println("------------");
		System.out.println(files);
		//		  String encoded = Base64.encodeBase64URLSafeString(files);
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
	public void guardarAlojamiento(@RequestBody AlojamientoDTO alojamiento) throws JSONException {
		alojamientoService.createAlojamiento(alojamiento);
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
}
