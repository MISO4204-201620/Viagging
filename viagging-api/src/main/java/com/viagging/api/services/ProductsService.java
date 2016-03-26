/*
 * 
 */
package com.viagging.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.api.model.Producto;
import com.viagging.api.model.mapper.ProductoMapper;
import com.viagging.api.util.ProductsUtil;
import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.core.model.Pregunta;
import com.viagging.core.services.ComentarioCalificacionService;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.PreguntaService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.mapper.ComentarioCalificacionDTOMapper;
import com.viagging.rest.dto.mapper.PaqueteDTOMapper;
import com.viagging.rest.dto.mapper.PreguntaDTOMapper;
import com.viagging.rest.dto.mapper.ServicioDTOMapper;

/**
 * The Class ProductoServiceImpl.
 */
@Service
public class ProductsService {

	/** The servicio service. */
	@Autowired
	private ServicioService servicioService;
	
	/** The paquete service. */
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private PreguntaService preguntaService;
	
	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;
	
	@Autowired
	private ServicioDTOMapper servicioDTOMapper;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	@Autowired
	private PreguntaDTOMapper preguntaDTOMapper;
	
	@Autowired
	private ComentarioCalificacionDTOMapper comentarioDTOMapper;
	
	@Autowired
	private ComentarioCalificacionService comentarioService;
	
	@Autowired
	private ProductsUtil productsUtil;
	
	public List<Producto> getAllProducts(){
		List<PaqueteDTO> paquetes = paqueteDTOMapper.mapObjectList(paqueteService.getAllPaquete());
		List<ServicioDTO> servicios = servicioDTOMapper.mapObjectList(servicioService.getAllServicio());
		return buildProductosFromPaquetesAndServicios(paquetes, servicios);
	}
	
	public Producto getProductById(String productId){	
		Integer id = productsUtil.getProductId(productId);
		Producto producto = new Producto();
		if(productsUtil.isPaqueteProducto(productId)){
			PaqueteDTO paquete = paqueteDTOMapper.mapObject(paqueteService.getPaqueteById(id));
			producto = productoMapper.buildProductoFromPaquete(paquete);
			
			List<Pregunta> preguntas = preguntaService.findPreguntasByPaquete(paquete.getId());
			if(preguntas != null){
				producto.setPreguntas(preguntaDTOMapper.mapObjectList(preguntas));
			}
			
			List<ComentarioCalificacion> comentarios = comentarioService.findComentariosByPaquete(paquete.getId());
			if(comentarios != null){
				producto.setComentarios(comentarioDTOMapper.mapObjectList(comentarios));
			}
			
		} else if(productsUtil.isServicioProducto(productId)){
			ServicioDTO servicio = servicioDTOMapper.mapObject(servicioService.getServicioById(id));
			producto = productoMapper.buildProductoFromServicio(servicio);
			
			List<Pregunta> preguntas = preguntaService.findPreguntasByServicio(servicio.getId());
			if(preguntas != null){
				producto.setPreguntas(preguntaDTOMapper.mapObjectList(preguntas));
			}
			
			List<ComentarioCalificacion> comentarios = comentarioService.findComentariosByServicio(servicio.getId());
			if(comentarios != null){
				producto.setComentarios(comentarioDTOMapper.mapObjectList(comentarios));
			}
		}
		return producto;
	}
	
	/**
	 * Builds the productos from paquetes and servicios.
	 *
	 * @param paquetes the paquetes
	 * @param servicios the servicios
	 * @return the list
	 */
	private List<Producto> buildProductosFromPaquetesAndServicios(List<PaqueteDTO> paquetes, List<ServicioDTO> servicios){
		List<Producto> productos = new ArrayList<>();
		for(PaqueteDTO paquete : paquetes){
			Producto productoPaquete = productoMapper.buildProductoFromPaquete(paquete);
			if(productoPaquete != null){
				productos.add(productoPaquete);
			}
		}
		for(ServicioDTO servicio : servicios){
			Producto productoServicio = productoMapper.buildProductoFromServicio(servicio);
			if(productoServicio != null){
				productos.add(productoServicio);
			}
		}
		return productos;
	}
	
}
