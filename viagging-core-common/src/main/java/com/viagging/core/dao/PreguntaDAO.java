package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Pregunta;

public interface PreguntaDAO {
	
	Pregunta getPreguntaById(Integer idPregunta);

	Pregunta createPregunta(Pregunta pregunta);

	Pregunta updatePregunta(Pregunta pregunta);
	
	Pregunta deletePregunta(Integer idPregunta);
	
	List<Pregunta> findPreguntasByPaquete(Integer idPaquete);
	
	List<Pregunta> findPreguntasByServicio(Integer idServicio);
}
