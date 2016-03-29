package com.viagging.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.services.PreguntaService;
import com.viagging.rest.dto.PreguntaDTO;

@RestController
public class QuestionController {
	
	@Autowired
	private PreguntaService preguntaService;
	
	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<PreguntaDTO> getQuestions() {
		List<PreguntaDTO> preguntas = preguntaService.findAllPreguntas();
		return preguntas;
	}
	
	@RequestMapping(value = "/answerQuestion", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void getQuestions(@RequestBody PreguntaDTO question) {
		preguntaService.responderPregunta(question);
	}
}
