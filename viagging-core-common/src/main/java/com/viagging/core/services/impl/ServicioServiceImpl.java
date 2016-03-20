package com.viagging.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.util.CategoryEnum;

@Service
public class ServicioServiceImpl implements ServicioService {

	
	@Autowired
	private ServicioDAO servicioDAO;

	@Override
	public Servicio getServicioById(Integer idServicio) {
		return servicioDAO.getServicioById(idServicio);
	}
  
	@Override
	public List<Servicio> getAllServicio() {
		return servicioDAO.getAllServicios();
	}

	@Override
	public Servicio createServicio(Servicio servicio) {
		return servicioDAO.createServicio(servicio);
	}

	@Override
	public Servicio updateServicio(Servicio servicio) {
		return servicioDAO.updateServicio(servicio);
	}
    
	@Override
	public List<Servicio> getAllServiciosByCategoria(String idCategoria) {
		
		if(CategoryEnum.ALIMENTACION.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosAlimentacion();			
		}else if(CategoryEnum.ALOJAMIENTO.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosAlojamiento();
		}else if(CategoryEnum.PASEO_ECOLOGICO.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosPaseoEcologico();
		} else{
			return servicioDAO.getAllServiciosTransporte();
		}
	}
	
	@Override
	public List<Servicio> buildListServices(List<ServicioDTO> listServiceDTO) {
		List<Servicio> listServicio = new ArrayList<>();
		for (ServicioDTO servicioDTO : listServiceDTO) {
			Servicio servicio = new Servicio();
			servicio.setId(servicioDTO.getId());
			listServicio.add(servicio);
		}
		
		return listServicio;
	}
}
