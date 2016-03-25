package com.viagging.api.services;

import java.util.List;

import com.viagging.api.model.Producto;

public interface ProductService {

	List<Producto> getAllProducts();
	
	Producto getProductById(String id);
	
}
