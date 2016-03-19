package com.viagging.rest.dto;

public class AlojamientoDTO {
  
    private String ciudad;
	
	private String valorPorNoche;
	
	private String restricciones;
	
	private String caracteristicas;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getValorPorNoche() {
		return valorPorNoche;
	}

	public void setValorPorNoche(String valorPorNoche) {
		this.valorPorNoche = valorPorNoche;
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
}
