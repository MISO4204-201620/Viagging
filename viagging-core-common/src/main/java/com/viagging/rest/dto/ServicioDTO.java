package com.viagging.rest.dto;



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

}
