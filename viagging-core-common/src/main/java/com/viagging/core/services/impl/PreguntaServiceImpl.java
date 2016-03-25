package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.PreguntaDAO;
import com.viagging.core.model.Pregunta;
import com.viagging.core.services.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService{
	
	@Autowired
	private PreguntaDAO preguntaDAO;

	@Override
	public Pregunta getPreguntaById(Integer idPregunta) {
		return preguntaDAO.getPreguntaById(idPregunta);
	}

	@Override
	public Pregunta createPregunta(Pregunta pregunta) {
		return preguntaDAO.createPregunta(pregunta);
	}

	@Override
	public Pregunta updatePregunta(Pregunta pregunta) {
		return preguntaDAO.updatePregunta(pregunta);
	}

	@Override
	public Pregunta deletePregunta(Integer idPregunta) {
		return preguntaDAO.deletePregunta(idPregunta);
	}

	@Override
	public List<Pregunta> findPreguntasByPaquete(Integer idPaquete) {
		return preguntaDAO.findPreguntasByPaquete(idPaquete);
	}

	@Override
	public List<Pregunta> findPreguntasByServicio(Integer idServicio) {
		return preguntaDAO.findPreguntasByServicio(idServicio);
	}

}
