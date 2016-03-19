package com.viagging.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaqueteDTO {
	
	private Integer id;

	private Boolean activo;
	
	private String nombrePaquete;
	
	private List<String>listaIdServicios;
	
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

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public List<String> getListaIdServicios() {
		return listaIdServicios;
	}

	public void setListaIdServicios(List<String> listaIdServicios) {
		this.listaIdServicios = listaIdServicios;
	}

}
