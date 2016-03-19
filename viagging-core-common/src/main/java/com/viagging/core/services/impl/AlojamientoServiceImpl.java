package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlojamientoDAO;
import com.viagging.core.model.Alojamiento;

@Service
public class AlojamientoServiceImpl implements AlojamientoDAO {

	@Autowired
	private AlojamientoDAO alojamientoDAO;

	@Override
	public Alojamiento getAlojamientoById(Integer idAlojamiento) {
		return alojamientoDAO.getAlojamientoById(idAlojamiento);
	}

	@Override
	public Alojamiento createAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.createAlojamiento(alojamiento);
	}

	@Override
	public Alojamiento updateAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.updateAlojamiento(alojamiento);
	}
	
	@Override
	public Alojamiento deleteAlojamiento(Integer idAlojamiento) {
		return alojamientoDAO.deleteAlojamiento(idAlojamiento);
	}
}
