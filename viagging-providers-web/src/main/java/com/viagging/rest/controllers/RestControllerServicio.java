package com.viagging.rest.controllers;


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

import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.TransporteDTO;

@RestController
public class RestControllerServicio {
	
	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	public static final String SERVICES_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	
	@Autowired
	private ServicioService servicioService;
		
	  @RequestMapping(value = "/getServiceTransport", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public TransporteDTO getServiceTransporte(@QueryParam("idService") String idService) {
		  System.out.println("getServiceTransporte"+idService);
		  
		  TransporteDTO transporte = new TransporteDTO();	  
		  ServicioDTO servicio = new ServicioDTO();
		  servicio.setDescripcionCorta("ddfdfdf");
		  servicio.setNombre("UBER");
		  servicio.setPrecio("150000");
		  transporte.setLugarDestino("lugarDestino");
		  transporte.setLugarOrigen("lugarOrigen");
		  transporte.setLugarDestino("lugarDestino");
		  transporte.setFrecuenciaSalida("frecuenciaSalida");
		  transporte.setHorarioFin("horarioFin");
		  transporte.setHorarioInicio("horarioInicio");
		  transporte.setNumeroPasajeros("numeroPasajeros");
		  transporte.setRestricciones("restricciones");
		  transporte.setTiempoEstimado("tiempoEstimado");
		  transporte.setTipoTransporte("tipoTransporte");
		  transporte.setServicio(servicio);
		  
		  /*ServicioDTO serviciDTO  = servicio.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		  if(serviciDTO == null){
      	      throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
          }*/
		  
		  return transporte;
	  }
	  
	  
	  @RequestMapping(value = "/getServiceAlojamiento", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public ServicioDTO getServiceAlojamiento(@QueryParam("idService") String idService) {
		  ServicioDTO servicio = new ServicioDTO();	  
		  ServicioDTO serviciDTO  = servicio.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		  if(serviciDTO == null){
      	      throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
          }
		  
		  return serviciDTO;
	  }
	  
	  @RequestMapping(value = "/getServices", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<ServicioDTO> getServices(@QueryParam("idCategory") String idCategory) {
          System.out.println("ingreso a getServices");	  
          ServicioDTO servicio = new ServicioDTO();	
		  List<ServicioDTO> listServicioDTO  = servicio.buildListObject(servicioService.getAllServicio());
          if(listServicioDTO.isEmpty()){
        	  throw new NotFoundException(SERVICES_ERROR_MESSAGE_NOT_FOUND);
          }
		  return listServicioDTO;
	  }
	  
	  @RequestMapping(value = "/addService", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void addService(@RequestBody ServicioDTO servicio) {
          System.out.println("ingreso a getServices");	  
          //servicioService.createServicio(servicio);
	  }
	  
	  @RequestMapping(value = "/deleteService", method = RequestMethod.DELETE)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void deleteService(@RequestBody String idService) {
          System.out.println("deleteService a getServices");	  
          //servicioService.createServicio(servicio);
	  }
}
