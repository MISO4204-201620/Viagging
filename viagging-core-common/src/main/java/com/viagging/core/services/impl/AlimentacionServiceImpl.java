package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.model.Alimentacion;
import com.viagging.core.services.AlimentacionService;


@Service
public class AlimentacionServiceImpl implements  AlimentacionService  {

	
	@Autowired
	private AlimentacionDAO alimentacionDAO;

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
}
