package com.viagging.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Payment;
import com.viagging.api.services.PaymentsService;
import com.viagging.core.constant.EstadoTransaccion;

@RestController
public class PaymentsController {
	
	@Autowired
	private PaymentsService paymentsService;
	
	@RequestMapping(value="/payments/submit", method = RequestMethod.POST)
	public ResponseEntity<EstadoTransaccion> submitPayment(@RequestBody Payment payment){
		return new ResponseEntity<>(paymentsService.submitPayment(payment), HttpStatus.OK);
	}

}
