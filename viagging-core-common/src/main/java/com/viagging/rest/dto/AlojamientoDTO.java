package com.viagging.rest.dto;

import java.util.Arrays;
import java.util.List;

import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;
public class AlojamientoDTO {
  
	private String ciudad;
	
	private String valorPorNoche;
	
	private String restricciones;
	
	private String caracteristicas;
    
	private ServicioDTO servicio;
	
	private byte[] imagenPrincipal;
	
	private List<ImagenDTO> imagenes;


	public AlojamientoDTO(String ciudad, String valorPorNoche,
			String restricciones,  ServicioDTO servicio,
			 byte[] imagenPrincipal) {
		super();
		this.ciudad = ciudad;
		this.valorPorNoche = valorPorNoche;
		this.restricciones = restricciones;
		this.servicio = servicio;
		this.imagenPrincipal = imagenPrincipal;
	}
	
	public AlojamientoDTO(){}


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
	
	public List<ImagenDTO> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDTO> imagenes) {
		this.imagenes = imagenes;
	}

	public AlojamientoDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = new ServicioDTO();
		parserServicio = parserServicio.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.ALOJAMIENTO.getId());
		Alojamiento alojamiento = servicio.getAlojamiento();
		AlojamientoDTO alojamientoDTO = new AlojamientoDTO(alojamiento.getCiudad(), String.valueOf(alojamiento.getValorpornoche()), alojamiento.getRestricciones(), parserServicio, alojamiento.getImagenprincipal());
		return alojamientoDTO;
	}

	@Override
	public String toString() {
		return "AlojamientoDTO [ciudad=" + ciudad + ", valorPorNoche=" + valorPorNoche + ", restricciones="
				+ restricciones + ", caracteristicas=" + caracteristicas + ", servicio=" + servicio
				+ ", imagenPrincipal=" + Arrays.toString(imagenPrincipal) + ", imagenes=" + imagenes + "]";
	}
}
