package com.viagging.rest.dto;



public class PaseoEcologicoDTO {
 	
	private String fecha;

	private String ciudad;
	
	private String tiempoDeRecorrido;
	
	private String horario;
	
	private String caracteristicas;
	
	private String restricciones;
	
	private String imagenPrincipal;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTiempoDeRecorrido() {
		return tiempoDeRecorrido;
	}

	public void setTiempoDeRecorrido(String tiempoDeRecorrido) {
		this.tiempoDeRecorrido = tiempoDeRecorrido;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}
}
