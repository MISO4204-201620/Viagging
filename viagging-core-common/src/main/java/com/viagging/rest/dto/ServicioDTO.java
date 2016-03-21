package com.viagging.rest.dto;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicioDTO {

	private Integer id;
	
	private Boolean activo;

	private String nombre;
	
	private String descripcionCorta;
	
	private String precio;
    
    private String idCategoria;

    private String ciudad;

    private PaqueteDTO paquete;



	public ServicioDTO() {
	}
	
	public ServicioDTO(Integer id, Boolean activo,
			String nombre, String descripcionCorta,String precio) {
		super();
		this.id = id;
		this.activo = activo;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.precio = precio;
	}
    

	public PaqueteDTO getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteDTO paquete) {
		this.paquete = paquete;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
	
	public List<ServicioDTO> buildListObject( List<Servicio> listServicio,String idCategory){
		 List<ServicioDTO> listServicioDTO = new ArrayList<>();
		 for (Servicio servicio : listServicio) {
		     ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), servicio.getActivo(), servicio.getNombre(), servicio.getDescripcion(),String.valueOf(servicio.getPrecio()));		 
			 servicioDTO.setIdCategoria(idCategory);
			 servicioDTO.getCiudadCategoria(servicio);
		     listServicioDTO.add(servicioDTO);
		}
		return listServicioDTO;
	}

	public ServicioDTO buildObject( Servicio servicio){
		 ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), servicio.getActivo(),  servicio.getNombre(), servicio.getDescripcion(),String.valueOf(servicio.getPrecio()));
		 servicioDTO.getCiudadCategoria(servicio);
		return servicioDTO;
	}
	
	@Override
	public String toString() {
		return "ServicioDTO [id=" + id + ", activo=" + activo + ", nombre="
				+ nombre + ", descripcionCorta=" + descripcionCorta
				+ ", precio=" + precio + ", idCategoria=" + idCategoria + "]";
	}
	
	private void getCiudadCategoria(Servicio servicio){
		String ciudad = "";
		if(servicio.getAlimentacion() != null){
			ciudad = servicio.getAlimentacion().getCiudad();
		}else if (servicio.getTransporte() != null){
			ciudad = servicio.getTransporte().getLugardestino();
		}else if(servicio.getAlojamiento() != null){
			ciudad = servicio.getAlojamiento().getCiudad();			
		}else if(servicio.getPaseoEcologico() != null){
			ciudad = servicio.getPaseoEcologico().getCiudad();
		}
		this.ciudad = ciudad;
	}
	
	public List<ServicioDTO> buildListServicioDTO( List<PaqueteServicio> listaPaqueteServicio){
		List<ServicioDTO> listaServicioDTO = new ArrayList<>();
		System.out.println("buildListServicioDTO");
		for (PaqueteServicio paqueteServicio : listaPaqueteServicio) {
			System.out.println(paqueteServicio.getServicio().getNombre());
			ServicioDTO servicioDTO = new ServicioDTO();
			servicioDTO = servicioDTO.buildObject(paqueteServicio.getServicio());
			servicioDTO.setPaquete(servicioDTO.buildPaquete(paqueteServicio.getServicio()));
			listaServicioDTO.add(servicioDTO);
		}
		return listaServicioDTO;
		
	}
	
	private PaqueteDTO buildPaquete(Servicio servicio){
		PaqueteDTO paquete = new PaqueteDTO();
		String idCategoria = "";
		if(servicio.getAlimentacion() != null){
			idCategoria = CategoryEnum.ALIMENTACION.getId();
			paquete.setNombre(CategoryEnum.ALIMENTACION.name());
		}else if (servicio.getTransporte() != null){
			idCategoria = CategoryEnum.TRANSPORTE.getId();
			paquete.setNombre(CategoryEnum.TRANSPORTE.name());
		}else if(servicio.getAlojamiento() != null){
			idCategoria = CategoryEnum.ALOJAMIENTO.getId();		
			paquete.setNombre(CategoryEnum.ALOJAMIENTO.name());
		}else if(servicio.getPaseoEcologico() != null){
			idCategoria = CategoryEnum.PASEO_ECOLOGICO.getId();
			paquete.setNombre(CategoryEnum.PASEO_ECOLOGICO.name());
		}
		   this.idCategoria = idCategoria;
		return paquete;
	}
	
	
}
