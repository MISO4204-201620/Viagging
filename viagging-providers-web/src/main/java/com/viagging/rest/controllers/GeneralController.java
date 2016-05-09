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

import com.viagging.core.constant.DocumentType;
import com.viagging.core.constant.Profile;
import com.viagging.core.model.Caracteristica;
import com.viagging.core.services.CaracteristicaService;
import com.viagging.core.services.ImagenServicioService;
import com.viagging.core.services.MovimientoService;
import com.viagging.rest.dto.DatosMonitoreoDTO;
import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.util.TransportEnum;

@RestController
public class GeneralController {
	
	@Autowired
	private CaracteristicaService featureService;
	
	@Autowired
	private ImagenServicioService imageService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	@RequestMapping(value = "/getFeatures", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getFeatures(@QueryParam("categoria") String categoria) {
		List<Caracteristica> features = featureService.getCaracteristicaByCategoria(categoria);
		List<String> fts = new ArrayList<>();
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
	
	@RequestMapping(value = "/getReportTypes", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getReportTypes() {
		List<String> reportTypes = new ArrayList<>();
		reportTypes.add("Busquedas");
		reportTypes.add("Consultas");
		reportTypes.add("Ventas");
		return reportTypes;
	}
	
	
	@RequestMapping(value = "/getServicesByProvider", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<String> getServicesByProvider() {
		List<String> reportTypes = new ArrayList<>();
		reportTypes.add("Busquedas");
		reportTypes.add("Consultas");
		reportTypes.add("Ventas");
		return reportTypes;
	}
	
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.PUT)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveImage(@RequestBody byte[] file, @QueryParam("idServicio") String idServicio) {
		imageService.createImagenServicio(file, idServicio);
	}
	
	@RequestMapping(value = "/getProfiles", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<NombreValorDTO> getProfiles() {
		return Profile.getKeyValuesWithoutUser();
	}
	
	@RequestMapping(value = "/getTypeDocuments", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<NombreValorDTO> getTypeDocuments() {
		return DocumentType.getKeyValues();
	}
	
	@RequestMapping(value = "/getRendimiento", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<DatosMonitoreoDTO> getMonitoreoRendimiento(@QueryParam("fechaInicial") String fechaInicial,@QueryParam("fechaFinal") String fechaFinal) {
		return movimientoService.findInfoMonitorero(fechaInicial, fechaFinal);
	}
}
