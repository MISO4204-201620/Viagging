package com.viagging.rest.dto;

public class PerfilDTO {
	
	private String id;

	private String nombre;

	@Override
	public String toString() {
		return "PerfilDTO [id=" + id + ", nombre=" + nombre + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
