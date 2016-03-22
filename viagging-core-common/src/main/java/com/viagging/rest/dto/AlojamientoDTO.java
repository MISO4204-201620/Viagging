package com.viagging.rest.dto;

import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;
public class AlojamientoDTO {
  
    private String ciudad;
	
	private String valorPorNoche;
	 
	private ServicioDTO servicio;
	
	public AlojamientoDTO(String ciudad, String valorPorNoche, ServicioDTO servicio) {
		super();
		this.ciudad = ciudad;
		this.valorPorNoche = valorPorNoche;
		this.servicio = servicio;
	}
	
	public AlojamientoDTO(){}

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

	public static AlojamientoDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.ALOJAMIENTO.getId());
		Alojamiento alojamiento = servicio.getAlojamiento();
		AlojamientoDTO alojamientoDTO = new AlojamientoDTO(alojamiento.getCiudad(), String.valueOf(alojamiento.getValorpornoche()), parserServicio);
		return alojamientoDTO;
	}
}
