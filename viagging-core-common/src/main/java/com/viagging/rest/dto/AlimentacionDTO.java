package com.viagging.rest.dto;

public class AlimentacionDTO {

	private String ciudad;

	private String horarioApertura;

	private String horarioCierre;
	
	private String restricciones;
	
	private String caracteristicas;
	
	private String precioMenor;
	
	private String precioMayor;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public String getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(String horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getPrecioMenor() {
		return precioMenor;
	}

	public void setPrecioMenor(String precioMenor) {
		this.precioMenor = precioMenor;
	}

	public String getPrecioMayor() {
		return precioMayor;
	}

	public void setPrecioMayor(String precioMayor) {
		this.precioMayor = precioMayor;
	}
}
