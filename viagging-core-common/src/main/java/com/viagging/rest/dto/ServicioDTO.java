package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.model.Servicio;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicioDTO {

	private Integer id;
	
	private Boolean activo;

	private Boolean datosServicio;

	private String nombre;
	
	private String descripcionCorta;
	
	private String precio;
    
    private String idCategoria;

	public ServicioDTO() {
	}
	
	public ServicioDTO(Integer id, Boolean activo, Boolean datosServicio,
			String nombre, String descripcionCorta,String precio, String idCategoria) {
		super();
		this.id = id;
		this.activo = activo;
		this.datosServicio = datosServicio;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getDatosServicio() {
		return datosServicio;
	}

	public void setDatosServicio(Boolean datosServicio) {
		this.datosServicio = datosServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public List<ServicioDTO> buildListObject( List<Servicio> listServicio){
		 List<ServicioDTO> listServicioDTO = new ArrayList<>();
		 /*for (Servicio servicio : listServicio) {
		 ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), 
			
					servicio.getActivo(), servicio.getDatosServicio(), servicio.getNombre(), "descripcion corta","555","01");
			 
			 listServicioDTO.add(servicioDTO);
		}	 */
		return listServicioDTO;
	}

	public ServicioDTO buildObject( Servicio servicio){
		 ServicioDTO servicioDTO = new ServicioDTO();
		
		return servicioDTO;
	}
}
