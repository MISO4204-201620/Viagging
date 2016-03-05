package com.viagging.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.services.PaqueteService;

@Service
public class PaqueteServiceImpl implements PaqueteService{

	@Autowired
	private PaqueteDAO paqueteDAO;

	@Override
	public Paquete getPaqueteById(Integer idPaquete) {
		return paqueteDAO.getPaqueteById(idPaquete);
	}

	@Override
	public List<Paquete> getAllPaquete() {
		return paqueteDAO.getAllPaquetes();
	}

	@Override
	public Paquete createPaquete(Paquete paquete) {
		return paqueteDAO.createPaquete(paquete);
	}

	@Override
	public Paquete updatePaquete(Paquete paquete) {
		return paqueteDAO.updatePaquete(paquete);
	}

}
