package com.viagging.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Producto;
import com.viagging.api.services.ProductsService;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.core.model.mapper.ComentarioCalificacionMapper;
import com.viagging.core.services.ComentarioCalificacionService;
import com.viagging.rest.dto.ComentarioCalificacionDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

/**
 * The Class ProductsController.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
	
	/** The product service. */
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ComentarioCalificacionService comentarioCalificacionService;
	
	@Autowired
	private ProductsUtil productsUtil;
	
	@Autowired
	private ComentarioCalificacionMapper comentarioCalificacionMapper;
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getAllProducts(){
		List<Producto> productos = productsService.getAllProducts();
		if(productos != null){
			return new ResponseEntity<>(productos, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> getProductByIdAndType(@PathVariable String id){
		Producto producto = productsService.getProductById(id);
		if(producto != null){
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public void addComment(@RequestBody ComentarioCalificacionDTO comentarioDTO, @PathVariable String id){
		Integer productId = productsUtil.getProductId(id);
		if(productsUtil.isPaqueteProducto(id)){
			PaqueteDTO paquete = new PaqueteDTO();
			paquete.setId(productId);
			comentarioDTO.setPaquete(paquete);
		} else if(productsUtil.isServicioProducto(id)){
			ServicioDTO servicio = new ServicioDTO();
			servicio.setId(productId);
			comentarioDTO.setServicio(servicio);
		}
		
		ComentarioCalificacion comentario = comentarioCalificacionMapper.mapObject(comentarioDTO);
		comentarioCalificacionService.createComentario(comentario);
	}
	
}