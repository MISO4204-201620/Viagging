package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Caracteristica;
import com.viagging.core.model.Pregunta;
import com.viagging.core.model.mapper.PreguntaMapper;
import com.viagging.core.services.CaracteristicaService;
import com.viagging.core.services.ImagenServicioService;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.PreguntaService;
import com.viagging.core.services.ServicioService;
import com.viagging.core.services.UsuarioService;
import com.viagging.rest.dto.PreguntaDTO;
import com.viagging.util.TransportEnum;

@RestController
public class GeneralController {
	
	@Autowired
	private CaracteristicaService featureService;
	
	@Autowired
	private ImagenServicioService imageService;
	
	@Autowired
	private PreguntaService preguntaService;
	
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PreguntaMapper preguntaMapper;
	
	@RequestMapping(value = "/getFeatures", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getFeatures(@QueryParam("categoria") String categoria) {
		List<Caracteristica> features = featureService.getCaracteristicaByCategoria(categoria);
		List<String> fts = new ArrayList<String>();
		for (Caracteristica feature : features) {
			fts.add(feature.getValor());
		}
		return fts;
	}
	
	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<PreguntaDTO> getQuestions() {
		System.out.println("por lo menos ingresa");
		List<PreguntaDTO> preguntas = preguntaService.findAllPreguntas();
//		List<Pregunta> newPreguntas = new ArrayList<>();
//		for (Pregunta pregunta : preguntas) {
//			System.out.println(pregunta.getPaquete() + "paquete");
//			if (pregunta.getPaquete() != null) {
//				pregunta.setPaquete(paqueteService.getPaqueteById(pregunta.getPaquete().getId()));
//			}
//			if (pregunta.getServicio() != null) {
//				System.out.println("llegando servicio" + pregunta.getServicio().getId());
//				pregunta.setServicio(servicioService.getServicioById(pregunta.getServicio().getId()));
//			}
//			pregunta.setUsuario(usuarioService.getUsuarioById(pregunta.getUsuario().getId()));
//			newPreguntas.add(pregunta);
//		}
		System.out.println(preguntas.size() + "tamaño");
		return preguntas;
//		if(preguntas != null){
//			System.out.println("retorna OK");
//			return new ResponseEntity<>(preguntas, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/getTransportTypes", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getTransportTypes() {
		return TransportEnum.getValues();
	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.PUT)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveImage(@RequestBody byte[] file, @QueryParam("idServicio") String idServicio) {
		imageService.createImagenServicio(file, idServicio);
	}

}
