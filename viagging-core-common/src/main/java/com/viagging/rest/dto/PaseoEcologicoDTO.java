package com.viagging.rest.dto;

import com.viagging.core.model.PaseoEcologico;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;



public class PaseoEcologicoDTO {
 	
	private String fecha;

	private String ciudad;
	
	private String tiempoDeRecorrido;
	
	private String horario;
	
	private String caracteristicas;
	
	private String restricciones;
	
	private byte[] imagenPrincipal;
    
	private ServicioDTO servicio;
	
	public PaseoEcologicoDTO(){}
	
	
	public PaseoEcologicoDTO(String fecha, String ciudad,
			String tiempoDeRecorrido, String horario,
			String restricciones, byte[] imagenPrincipal, ServicioDTO servicio) {
		super();
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.tiempoDeRecorrido = tiempoDeRecorrido;
		this.horario = horario;
		this.restricciones = restricciones;
		this.imagenPrincipal = imagenPrincipal;
		this.servicio = servicio;
	}

	public byte[] getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(byte[] imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

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

	
	public PaseoEcologicoDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = new ServicioDTO();
		parserServicio = parserServicio.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.PASEO_ECOLOGICO.getId());
		PaseoEcologico paseoEcologico = servicio.getPaseoEcologico();	
		PaseoEcologicoDTO paseoEcologicoDTO = new PaseoEcologicoDTO(paseoEcologico.getFecha().toString(),paseoEcologico.getCiudad(),
				paseoEcologico.getTiempoderecorrido(), paseoEcologico.getHorario(),  paseoEcologico.getRestricciones(), paseoEcologico.getImagenprincipal(), parserServicio);
		return paseoEcologicoDTO;
		
	}
}
