package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.model.Servicio;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicioDTO {

	private Integer id;
	
	private Boolean activo;

	private Boolean datosServicio;

	private String nombre;

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

	public Boolean getDatosServicio() {
		return datosServicio;
	}

	public void setDatosServicio(Boolean datosServicio) {
		this.datosServicio = datosServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<ServicioDTO> buildListObject( List<Servicio> listServicio){
		 List<ServicioDTO> listServicioDTO = new ArrayList<>();
		
		return listServicioDTO;
	}

	public ServicioDTO buildObject( Servicio servicio){
		 ServicioDTO servicioDTO = new ServicioDTO();
		
		return servicioDTO;
	}
}
