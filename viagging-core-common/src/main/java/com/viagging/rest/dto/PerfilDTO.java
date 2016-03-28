package com.viagging.rest.dto;

import com.viagging.core.model.Perfil;
import com.viagging.core.model.Usuario;

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
	
	public static PerfilDTO buildObject(Perfil perfil){
		PerfilDTO perfilDto = new PerfilDTO();
		perfilDto.setId(String.valueOf(perfil.getId()));
		perfilDto.setNombre(perfil.getNombre());
		return perfilDto;
	}
}
