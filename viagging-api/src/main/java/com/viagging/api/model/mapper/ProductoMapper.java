package com.viagging.api.model.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.api.constants.ProductType;
import com.viagging.api.model.Producto;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

@Component
public class ProductoMapper {
	
	/**
	 * Builds the producto from paquete.
	 *
	 * @param paquete the paquete
	 * @return the producto
	 */
	public Producto buildProductoFromPaquete(PaqueteDTO paquete){
		if(paquete.getServicios() == null){
			return null;
		}
		Producto producto = new Producto();
		producto.setId(ProductType.PAQUETE.getPrefix() + paquete.getId());
		producto.setNombre(paquete.getNombre());
		producto.setDescripcion(paquete.getDescripcion());
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
	public Producto buildProductoFromServicio(ServicioDTO servicio){
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
