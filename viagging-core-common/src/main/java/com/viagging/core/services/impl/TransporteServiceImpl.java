package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.TransporteDAO;
import com.viagging.core.model.Transporte;
import com.viagging.core.services.TransporteService;

@Service
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteDAO transporteDAO;

	@Override
	public Transporte getTransporteById(Integer idTransporte) {
		return transporteDAO.getTransporteById(idTransporte);
	}

	@Override
	public Transporte createTransporte(Transporte transporte) {
		return transporteDAO.createTransporte(transporte);
	}

	@Override
	public 	Transporte updateTransporte(Transporte transporte){
		return transporteDAO.updateTransporte(transporte);
	}
	
	@Override
	public Transporte deleteTransporte(Integer idTransporte) {
		return transporteDAO.deleteTransporte(idTransporte);
	}
}
