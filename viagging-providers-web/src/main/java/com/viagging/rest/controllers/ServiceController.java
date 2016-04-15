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

import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.AlimentacionDTO;
import com.viagging.rest.dto.AlojamientoDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.PaseoEcologicoDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.TransporteDTO;

@RestController
public class ServiceController {

	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	public static final String SERVICES_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "servicios no encontrados";

	@Autowired
	private ServicioService servicioService;

	@RequestMapping(value = "/getServiceTransport", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public TransporteDTO getServiceTransporte(@QueryParam("idService") String idService) {
		System.out.println("getServiceTransporte" + idService);
		TransporteDTO transporteDTO = TransporteDTO.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		if (transporteDTO == null) {
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}

		return transporteDTO;
	}

	@RequestMapping(value = "/getServiceAlimentacion", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public AlimentacionDTO getServiceAlimentacion(@QueryParam("idService") String idService) {
		System.out.println("getServiceTransporte" + idService);
		AlimentacionDTO alimentacionDTO = AlimentacionDTO.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		if (alimentacionDTO == null) {
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}

		return alimentacionDTO;
	}

	@RequestMapping(value = "/getServiceAlojamiento", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public AlojamientoDTO getServiceAlojamiento(@QueryParam("idService") String idService) {
		System.out.println("getServiceAlojamiento" + idService);
		AlojamientoDTO alojamientoDTO = AlojamientoDTO.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		if (alojamientoDTO == null) {
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}
		return alojamientoDTO;
	}

	@RequestMapping(value = "/getServicePaseoEcologico", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public PaseoEcologicoDTO getServicePaseoEcologico(@QueryParam("idService") String idService) {
		System.out.println("getServiceAlojamiento" + idService);
		PaseoEcologicoDTO paseoEcologicoDTO = PaseoEcologicoDTO.buildObject(servicioService.getServicioById(Integer.valueOf(idService)));
		if (paseoEcologicoDTO == null) {
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}
		return paseoEcologicoDTO;
	}

	@RequestMapping(value = "/getServices", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<ServicioDTO> getServices(@QueryParam("idCategory") String idCategory) {
		System.out.println("ingreso a getServices");
		List<ServicioDTO> listServicioDTO = ServicioDTO.buildListObject(servicioService.getAllServiciosByCategoria(idCategory));
		if (listServicioDTO.isEmpty()) {
			throw new NotFoundException(SERVICES_ERROR_MESSAGE_NOT_FOUND);
		}
		return listServicioDTO;
	}

	@RequestMapping(value = "/addService", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addService(@RequestBody ServicioDTO servicio) {
		System.out.println("ingreso a addService");
		// servicioService.createServicio(servicio);
	}

	@RequestMapping(value = "/deleteService", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteService(@RequestBody String idService) {
		System.out.println("ingreso a deleteService");
		// servicioService.createServicio(servicio);
	}
	
	@RequestMapping(value = "/activeService", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void activeService(@RequestBody ServicioDTO servicioDTO) {
    	System.out.println(servicioDTO.getId() + "id1");
		Servicio service = servicioService.buildServicio(servicioDTO);
    	service.setId(servicioDTO.getId());
		servicioService.activarServicio(service);
    }
	
	@RequestMapping(value = "/getServicesByProveedor", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<ServicioDTO> getServicesByProveedor(@QueryParam("idCategory") String idCategory,@QueryParam("idProveedor") String idProveedor) {
		System.out.println("getServicesByProveedor");
		List<ServicioDTO> listServicioDTO = ServicioDTO.buildListObject(servicioService.getServiciosByCategoriaProveedor(idCategory, idProveedor));
		if (listServicioDTO.isEmpty()) {
			throw new NotFoundException(SERVICES_ERROR_MESSAGE_NOT_FOUND);
		}
		return listServicioDTO;
	}

}
