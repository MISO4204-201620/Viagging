package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

@RestController
public class RestControllerPaquete {

	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	public static final String SERVICES_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	
	@Autowired
	private ServicioService servicioService;
	

	  @RequestMapping(value = "/addPackage", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void savePost(@RequestBody PaqueteDTO packateSave) {
          		  
		  /*ServicioDTO serviciDTO  = servicioDTO.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		  if(serviciDTO == null){
      	      throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
          }*/
		  
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
	  public PaqueteDTO getPackage(@RequestBody String idPackage) {
          System.out.println("deletePackage");	  
		  PaqueteDTO paquete = new PaqueteDTO();
		  return paquete;
	  }
	  
	  @RequestMapping(value = "/getPackages", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<PaqueteDTO> getPackages(@RequestBody String idCategory) {
          System.out.println("deletePackage");	  
          List<PaqueteDTO> listPaquete = new ArrayList<>();
		  return listPaquete;
	  }
}
