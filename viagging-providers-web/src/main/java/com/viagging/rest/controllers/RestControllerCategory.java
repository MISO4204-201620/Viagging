package com.viagging.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.util.CategoryEnum;

@RestController
public class RestControllerCategory {

	
	  @RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<NombreValorDTO> getCategory() {
		  System.out.println("ingreso getCategory ");
		  List<NombreValorDTO> listCategory = CategoryEnum.getKeyValues();
		  
		  return listCategory;
	  }
}
