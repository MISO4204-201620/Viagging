package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.AlimentacionService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.AlimentacionDTO;


@Service
public class AlimentacionServiceImpl implements  AlimentacionService  {

	
	@Autowired
	private AlimentacionDAO alimentacionDAO;
	
	@Autowired
	private ServicioService servicioService;

	@Override
	public Alimentacion getAlimentacionById(Integer idAlimentacion) {
		return alimentacionDAO.getAlimentacionById(idAlimentacion);
	}

	@Override
	public Alimentacion createAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.createAlimentacion(alimentacion);
	}

	@Override
	public Alimentacion updateAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.updateAlimentacion(alimentacion);
	}
	
	@Override
	public Alimentacion deleteAlimentacion(Integer idAlimentacion) {
		return alimentacionDAO.deleteAlimentacion(idAlimentacion);
	}

	@Override
	public void createAlimentacion(AlimentacionDTO alimentacionDTO) {
		Alimentacion alimentacion = alimentacionDTOToModel(alimentacionDTO);
		createAlimentacion(alimentacion);
	}
	
	private Alimentacion alimentacionDTOToModel(AlimentacionDTO alimentacionDTO) {
		Alimentacion alimentacion = new Alimentacion();
		alimentacion.setCiudad(alimentacionDTO.getCiudad());
		alimentacion.setHorarioapertura(alimentacionDTO.getHorarioApertura());
		alimentacion.setHorariocierre(alimentacionDTO.getHorarioCierre());
		alimentacion.setPreciomayor(Integer.parseInt(alimentacionDTO.getPrecioMayor()));
		alimentacion.setPreciomenor(Integer.parseInt(alimentacionDTO.getPrecioMenor()));
		Servicio servicio = servicioService.servicioDTOToModel(alimentacionDTO.getServicio());
		servicioService.createServicio(servicio);
		return alimentacion;
	}
}
