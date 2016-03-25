package com.viagging.api.model;

import java.math.BigDecimal;
import java.util.List;

import com.viagging.api.constants.ProductType;
import com.viagging.rest.dto.ServicioDTO;

/**
 * The Class Producto.
 */
public class Producto {

	/** The producto id. */
	private String id;
	
	/** The nombre. */
	private String nombre;
	
	/** The descripcion. */
	private String descripcion;
	
	/** The precio. */
	private BigDecimal precio;
	
	private ProductType tipoProducto;
	
	private Boolean activo;
	
	/** The servicios. */
	private List<ServicioDTO> servicios;
	
	/**
	 * Gets the producto id.
	 *
	 * @return the producto id 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the producto id.
	 *
	 * @param id the new producto id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	/**
	 * Gets the tipo producto.
	 *
	 * @return the tipo producto
	 */
	public ProductType getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Sets the tipo producto.
	 *
	 * @param tipoProducto the new tipo producto
	 */
	public void setTipoProducto(ProductType tipoProducto) {
		this.tipoProducto = tipoProducto;
	}		

	/**
	 * Gets the activo.
	 *
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 *
	 * @param activo the new activo
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the servicios.
	 *
	 * @return the servicios
	 */
	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	/**
	 * Sets the servicios.
	 *
	 * @param servicios the new servicios
	 */
	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}
	
}
