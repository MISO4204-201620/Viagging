package com.viagging.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Payment;
import com.viagging.api.services.PaymentsService;
import com.viagging.core.model.Orden;

@RestController
public class PaymentsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsController.class); 
	
	@Autowired
	private PaymentsService paymentsService;
	
	@RequestMapping(value="/payments/submit", method = RequestMethod.POST)
	public ResponseEntity<Orden> submitPayment(@RequestBody Payment payment){
		try{
			return new ResponseEntity<>(paymentsService.submitPayment(payment), HttpStatus.OK);
		} catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
