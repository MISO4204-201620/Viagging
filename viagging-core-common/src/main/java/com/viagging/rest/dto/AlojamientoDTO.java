package com.viagging.rest.dto;

import org.springframework.util.StringUtils;

import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;

public class AlojamientoDTO {
  
    private String ciudad;
	
	private String valorPorNoche;
	
	private String restricciones;
	
	private String caracteristicas;
    
	private ServicioDTO servicio;
	
	private String imagenPrincipal;

	public AlojamientoDTO(String ciudad, String valorPorNoche,
			String restricciones,  ServicioDTO servicio,
			 String imagenPrincipal) {
		super();
		this.ciudad = ciudad;
		this.valorPorNoche = valorPorNoche;
		this.restricciones = restricciones;
		this.servicio = servicio;
		this.imagenPrincipal = imagenPrincipal;
	}
	
	public AlojamientoDTO(){}

	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

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
	
	public AlojamientoDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.ALOJAMIENTO.getId());
		Alojamiento alojamiento = servicio.getAlojamiento();
		
		String imagenPrincipal = "";
		if(alojamiento.getImagenprincipal() != null){
			imagenPrincipal = new String(alojamiento.getImagenprincipal());
		}
				
		AlojamientoDTO alojamientoDTO = new AlojamientoDTO(alojamiento.getCiudad(), String.valueOf(alojamiento.getValorpornoche()), alojamiento.getRestricciones(), parserServicio, imagenPrincipal);
		return alojamientoDTO;
	}
}
