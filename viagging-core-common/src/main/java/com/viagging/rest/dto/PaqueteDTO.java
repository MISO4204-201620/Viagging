package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.model.Paquete;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaqueteDTO {
	
	private Integer id;

	private Boolean activo;
	
	private String nombre;
	
	private String precio;
	
	private String descripcion;
	
	private List<ServicioDTO>servicios;
	
	public PaqueteDTO(){}
	
	public PaqueteDTO(Integer id, Boolean activo, String nombre, String precio,String descripcion) {
		super();
		this.id = id;
		this.activo = activo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "PaqueteDTO [id=" + id + ", activo=" + activo + ", nombre="
				+ nombre + ", precio=" + precio + ", servicios=" + servicios
				+ "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
    
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<PaqueteDTO> buildListObject(List<Paquete> listaPaquete){
		List<PaqueteDTO> listaPaqueteDTO = new ArrayList<>();
		for (Paquete paquete : listaPaquete) {
			PaqueteDTO paqueteDTO = new PaqueteDTO(paquete.getId(), paquete.getActivo(), paquete.getNombrePaquete(), String.valueOf(paquete.getPrecio()),paquete.getDescripcion());
		    listaPaqueteDTO.add(paqueteDTO);
		}
		return listaPaqueteDTO;
	}

}
