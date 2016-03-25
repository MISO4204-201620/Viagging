package com.viagging.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Producto;
import com.viagging.api.services.ProductService;

/**
 * The Class ProductsController.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
	
	/** The product service. */
	@Autowired
	private ProductService productService;
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getAllProducts(){
		List<Producto> productos = productService.getAllProducts();
		if(productos != null){
			return new ResponseEntity<>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> getProductByIdAndType(@PathVariable String id){
		Producto producto = productService.getProductById(id);
		if(producto != null){
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}