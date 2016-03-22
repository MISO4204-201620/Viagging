package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.QueryParam;

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
public class RestControllerPaquete {

	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	public static final String SERVICES_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
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
	  public void savePost(@RequestBody PaqueteDTO paqueteDTO) {
          		  System.out.println(paqueteDTO);
         Paquete paquete = 	paqueteService.buildPaquete(paqueteDTO);
         List<Servicio> listaServicio = servicioService.buildListServices(paqueteDTO.getServicios()); 
         paqueteService.createPaquete(paquete, listaServicio, "1");
	  }
	  
	  @RequestMapping(value = "/deletePackage", method = RequestMethod.DELETE)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<ServicioDTO> deletePackage(@RequestBody String idPackage) {
          System.out.println("deletePackage");	
          ServicioDTO servicioDTO = new ServicioDTO();
		  List<ServicioDTO> listServicioDTO  = servicioDTO.buildListObject(servicioService.getAllServicio());
          if(listServicioDTO.isEmpty()){
        	  throw new NotFoundException(SERVICES_ERROR_MESSAGE_NOT_FOUND);
          }
		  return listServicioDTO;
	  }
	  
	  @RequestMapping(value = "/editPackage", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<ServicioDTO> editPackage(@RequestBody PaqueteDTO packateEdit) {
          System.out.println("deletePackage");
          ServicioDTO servicioDTO = new ServicioDTO();
		  List<ServicioDTO> listServicioDTO  = servicioDTO.buildListObject(servicioService.getAllServicio());
          if(listServicioDTO.isEmpty()){
        	  throw new NotFoundException(SERVICES_ERROR_MESSAGE_NOT_FOUND);
          }
		  return listServicioDTO;
	  }
	  
	  @RequestMapping(value = "/getPackage", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<ServicioDTO> getPackage(@QueryParam("idPackage") String idPackage) {
          System.out.println("getPackage"+idPackage);	  
          List<ServicioDTO> listaServicios = new ArrayList<>();
          ServicioDTO servicioDTO = new ServicioDTO();
          List<PaqueteServicio> listPaqueteServicio = paqueteServicioService.getPaqueteServicioByIdPaquete(idPackage);
          listaServicios   = servicioDTO.buildListServicioDTO(listPaqueteServicio);

		  return listaServicios;
	  }
	  
	  @RequestMapping(value = "/getPackages", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<PaqueteDTO> getPackages(@QueryParam("filtro") String filtro) {
          System.out.println("deletePackage"+filtro);
          PaqueteDTO paqueteDTO = new PaqueteDTO(); 
          List<Paquete>  listPackages = paqueteService.getAllPaquetesByFiltro(filtro);
          List<PaqueteDTO> listPaquete = paqueteDTO.buildListObject(listPackages);
    		  if(listPaquete.isEmpty()){
            	  throw new NotFoundException(PACKAGE_ERROR_MESSAGE_NOT_FOUND);
    		  }
		
          return listPaquete;	  
      }
}