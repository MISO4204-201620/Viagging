package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.PreguntaFrecuente;
import com.viagging.rest.dto.PreguntaFrecuenteDTO;

public interface PreguntaFrecuenteService {
	
	PreguntaFrecuente getPreguntaFrecuenteById(Integer idPreguntaFrecuente);
	
	List<PreguntaFrecuente> getAllPreguntasFrecuentes();

	PreguntaFrecuente createPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente updatePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente deletePreguntaFrecuente(Integer idPreguntaFrecuente);
	
	List<PreguntaFrecuente> buildPreguntasFrecuentes(List<PreguntaFrecuenteDTO> listaPreguntaFrecuenteDTO);
}
