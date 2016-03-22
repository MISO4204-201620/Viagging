package com.viagging.rest.dto;

import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;

public class AlimentacionDTO {

	private String ciudad;

	private String horarioApertura;
	
	private String restricciones;
	
	private String caracteristicas;
	
	private String precioMenor;
	
	private String precioMayor;
	
	private String imagenPrincipal;
	


	private ServicioDTO servicio;



	public AlimentacionDTO(){}

	public AlimentacionDTO(String ciudad, String horarioApertura, String restricciones,
			String precioMenor, String precioMayor, String imagenPrincipal,
			ServicioDTO servicio) {
		super();
		this.ciudad = ciudad;
		this.horarioApertura = horarioApertura;
		this.restricciones = restricciones;
		this.precioMenor = precioMenor;
		this.precioMayor = precioMayor;
		this.imagenPrincipal = imagenPrincipal;
		this.servicio = servicio;
	}


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

	public String getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
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
	
	public static AlimentacionDTO buildObject( Servicio servicio){
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.ALIMENTACION.getId());
		Alimentacion alimentacion = servicio.getAlimentacion();
		String imagenPrincipal = new String(alimentacion.getImagenprincipal());
		AlimentacionDTO alimentacionDTO = new AlimentacionDTO(alimentacion.getCiudad(), alimentacion.getHorarioapertura(),  alimentacion.getRestricciones(), String.valueOf(alimentacion.getPreciomenor()), String.valueOf(alimentacion.getPreciomayor()), imagenPrincipal,parserServicio);

		return alimentacionDTO;
	}
}
