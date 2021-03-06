package com.viagging.rest.controllers;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.PaqueteServicioService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

@RestController
public class PackageController {

	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	public static final String SERVICES_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "servicio no encontrado";
	public static final String PACKAGE_ERROR_MESSAGE_NOT_FOUND = "No existen paquetes";
	
	@Autowired
	private ServicioService servicioService;
	
    @Autowired
	private PaqueteService paqueteService;
    
    @Autowired
	private PaqueteDAO paqueteDAO;
    
    @Autowired
  	private PaqueteServicioService paqueteServicioService;
	
    @RequestMapping(value = "/addPackage", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addPackage( @RequestBody PaqueteDTO paqueteDTO) {
    	Paquete paquete = paqueteService.buildPaquete(paqueteDTO);
    	List<Servicio> listaServicio = servicioService.buildListServices(paqueteDTO.getServicios()); 
    	paqueteService.createPaquete(paquete, listaServicio, paqueteDTO.getUsuario().getId());
    }
	  
    @RequestMapping(value = "/deletePackage", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePackage(@RequestBody String idPackage) {
    	paqueteService.deletePaquete(Integer.valueOf(idPackage));
    }
	  
    @RequestMapping(value = "/editPackage", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void editPackage(@RequestBody PaqueteDTO paqueteDTO) {
    	Paquete paquete = paqueteService.buildPaquete(paqueteDTO);
    	paqueteService.updatePaquete(paquete);
    	
	}
	  
    @RequestMapping(value = "/getPackage", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ServicioDTO> getPackage(@QueryParam("idPackage") String idPackage) {
    	List<PaqueteServicio> listPaqueteServicio = paqueteServicioService.getPaqueteServicioByIdPaquete(idPackage);
    	return ServicioDTO.buildListServicioDTO(listPaqueteServicio);
    }
	  
    @RequestMapping(value = "/getPackages", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<PaqueteDTO> getPackages(@QueryParam("filtro") String filtro,@QueryParam("idUsuario") String idUsuario) {
    	List<Paquete> listPackages = paqueteService.getAllPaquetesByFiltro(filtro,NumberUtils.toInt(idUsuario));
    	List<PaqueteDTO> listPaquete = PaqueteDTO.buildListObject(listPackages);
    	if(listPaquete.isEmpty()){
    		throw new NotFoundException(PACKAGE_ERROR_MESSAGE_NOT_FOUND);
    	}
		
    	return listPaquete;	  
    }
    
    @RequestMapping(value = "/activatePackage", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void activatePackage(@RequestBody PaqueteDTO paqueteDTO) {
    	Paquete paquete = paqueteService.buildPaquete(paqueteDTO);
    	paqueteService.activatePaquete(paquete);
    }
    
}