package com.viagging.rest.dto;

public class TransporteDTO {
    
	private ServicioDTO servicio;
		
	private String tipoTransporte;
	
	private String lugarOrigen;
	
	private String lugarDestino;
	
	private String tiempoEstimado;
	
	private String horarioInicio;
	
	private String horarioFin;
	
	private String restricciones;
	
	private String frecuenciaSalida;
	
	private String numeroPasajeros;
	
	private String imagenPrincipal;
	
	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public String getNumeroPasajeros() {
		return numeroPasajeros;
	}

	public void setNumeroPasajeros(String numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getFrecuenciaSalida() {
		return frecuenciaSalida;
	}

	public void setFrecuenciaSalida(String frecuenciaSalida) {
		this.frecuenciaSalida = frecuenciaSalida;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
}
