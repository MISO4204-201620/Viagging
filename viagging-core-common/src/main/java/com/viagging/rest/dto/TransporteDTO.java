package com.viagging.rest.dto;

import com.viagging.core.model.Servicio;
import com.viagging.core.model.Transporte;
import com.viagging.util.CategoryEnum;

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
	
	public TransporteDTO(){
		
	}
	
	public TransporteDTO(ServicioDTO servicio, String tipoTransporte,
			String lugarOrigen, String lugarDestino, String tiempoEstimado,
			String horarioInicio, String horarioFin, String restricciones,
			String frecuenciaSalida, String numeroPasajeros,
			String imagenPrincipal) {
		super();
		this.servicio = servicio;
		this.tipoTransporte = tipoTransporte;
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.tiempoEstimado = tiempoEstimado;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
		this.restricciones = restricciones;
		this.frecuenciaSalida = frecuenciaSalida;
		this.numeroPasajeros = numeroPasajeros;
		this.imagenPrincipal = imagenPrincipal;
	}

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
	
	public TransporteDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.TRANSPORTE.getId());
		Transporte transporte = servicio.getTransporte();
		String imagenPrincipal = "";
		if(transporte.getImagenprincipal() != null){
			imagenPrincipal = new String(transporte.getImagenprincipal());
		}
		TransporteDTO transporteDTO = new TransporteDTO(parserServicio, transporte.getTipotransporte(), transporte.getLugarorigen(), transporte.getLugardestino(),
				transporte.getTiempoestimado(), transporte.getHorarioinicio(), transporte.getHorariofin(), transporte.getRestricciones(), transporte.getFrecuenciasalida(),String.valueOf(transporte.getNumeropasajeros()),imagenPrincipal);
		return transporteDTO;
	}
}
