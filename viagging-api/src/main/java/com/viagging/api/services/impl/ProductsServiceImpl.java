/*
 * 
 */
package com.viagging.api.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.viagging.api.constants.ProductType;
import com.viagging.api.model.Producto;
import com.viagging.api.services.ProductService;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.mapper.PaqueteDTOMapper;
import com.viagging.rest.dto.mapper.ServicioDTOMapper;

/**
 * The Class ProductoServiceImpl.
 */
@Service
public class ProductsServiceImpl implements ProductService {

	/** The servicio service. */
	@Autowired
	private ServicioService servicioService;
	
	/** The paquete service. */
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;
	
	@Autowired
	private ServicioDTOMapper servicioDTOMapper;
	
	@Override
	public List<Producto> getAllProducts(){
		List<PaqueteDTO> paquetes = paqueteDTOMapper.mapObjectList(paqueteService.getAllPaquete());
		List<ServicioDTO> servicios = servicioDTOMapper.mapObjectList(servicioService.getAllServicio());
		return buildProductosFromPaquetesAndServicios(paquetes, servicios);
	}
	
	@Override
	public Producto getProductById(String productId){
		Producto producto = new Producto();
		
		Integer id = Integer.parseInt(productId.replaceAll("[\\D]", ""));
		
		if(StringUtils.startsWithIgnoreCase(productId, ProductType.PAQUETE.getPrefix())){
			PaqueteDTO paquete = paqueteDTOMapper.mapObject(paqueteService.getPaqueteById(id));
			producto = buildProductoFromPaquete(paquete);
		} else if(StringUtils.startsWithIgnoreCase(productId, ProductType.SERVICIO.getPrefix())){
			ServicioDTO servicio = servicioDTOMapper.mapObject(servicioService.getServicioById(id));
			producto = buildProductoFromServicio(servicio);
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
			Producto productoPaquete = buildProductoFromPaquete(paquete);
			if(productoPaquete != null){
				productos.add(productoPaquete);
			}
		}
		for(ServicioDTO servicio : servicios){
			productos.add(buildProductoFromServicio(servicio));
		}
		return productos;
	}
	
	/**
	 * Builds the producto from paquete.
	 *
	 * @param paquete the paquete
	 * @return the producto
	 */
	private Producto buildProductoFromPaquete(PaqueteDTO paquete){
		if(paquete.getServicios() == null){
			return null;
		}
		Producto producto = new Producto();
		producto.setId(ProductType.PAQUETE.getPrefix() + paquete.getId());
		producto.setNombre(paquete.getNombre());
		producto.setDescripcion("");
		producto.setTipoProducto(ProductType.PAQUETE);
		producto.setServicios(paquete.getServicios());
		producto.setPrecio(new BigDecimal(paquete.getPrecio()));
		producto.setActivo(paquete.getActivo());
		return producto;
	}
	
	/**
	 * Builds the producto from servicio.
	 *
	 * @param servicio the servicio
	 * @return the producto
	 */
	private Producto buildProductoFromServicio(ServicioDTO servicio){
		Producto producto = new Producto();
		producto.setId(ProductType.SERVICIO.getPrefix() + servicio.getId());
		producto.setNombre(servicio.getNombre());
		producto.setDescripcion(servicio.getDescripcionCorta());
		producto.setTipoProducto(ProductType.SERVICIO);
		producto.setPrecio(new BigDecimal(servicio.getPrecio()));
		producto.setActivo(servicio.getActivo());
		List<ServicioDTO> servicios = new ArrayList<>();
		servicios.add(servicio);
		producto.setServicios(servicios);
		return producto;
	}
	
}
