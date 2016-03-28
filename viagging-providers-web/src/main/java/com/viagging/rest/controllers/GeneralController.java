package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;
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

import com.viagging.core.constant.DocumentType;
import com.viagging.core.constant.Profile;
import com.viagging.core.model.Caracteristica;
import com.viagging.core.services.CaracteristicaService;
import com.viagging.core.services.ImagenServicioService;
import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.util.CategoryEnum;
import com.viagging.util.TransportEnum;

@RestController
public class GeneralController {
	
	@Autowired
	private CaracteristicaService featureService;
	
	@Autowired
	private ImagenServicioService imageService;
	
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
	
	@RequestMapping(value = "/getTransportTypes", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getTransportTypes() {
		return TransportEnum.getValues();
	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.PUT)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveImage(@RequestBody String file, @QueryParam("idServicio") String idServicio) {
		System.out.println(idServicio + "ids");
		imageService.createImagenServicio(file, idServicio);
	}
	
	@RequestMapping(value = "/getProfiles", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<NombreValorDTO> getProfiles() {
		System.out.println("ingreso perfil ");
		List<NombreValorDTO> listProfile = Profile.getKeyValuesWithoutUser();

		return listProfile;
	}
	
	@RequestMapping(value = "/getTypeDocuments", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<NombreValorDTO> getTypeDocuments() {
		System.out.println("ingreso getTypeDocuments ");
		List<NombreValorDTO> listDocument = DocumentType.getKeyValues();

		return listDocument;
	}


}
