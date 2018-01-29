package com.viagging.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.services.AlimentacionService;
import com.viagging.rest.dto.AlimentacionDTO;

@RestController
public class FoodController {
	
	@Autowired
	private AlimentacionService foodService;

	@RequestMapping(value = "/saveFood", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public Integer saveFood(@RequestBody AlimentacionDTO alimentacion) {
		return foodService.createAlimentacion(alimentacion);
	}
}
