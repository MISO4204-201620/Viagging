package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	private CategoryEnum categoria;

	private String ciudad;

	private PaqueteDTO paquete;

	private String imagenPrincipal;

	private List<String> imagenes;

	private String restricciones;

	private List<CaracteristicasDTO> caracteristicas;
	
	private AlimentacionDTO alimentacion;
	
	private AlojamientoDTO alojamiento;
	
	private PaseoEcologicoDTO paseoEcologico;
	
	private TransporteDTO transporte;

	public ServicioDTO() {
	}

	public ServicioDTO(Integer id, Boolean activo, String nombre,
			String descripcionCorta, String precio, String restricciones) {
		super();
		this.id = id;
		this.activo = activo;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.precio = precio;
		this.restricciones = restricciones;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public List<CaracteristicasDTO> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas1) {
		try {
			JSONObject jsonObj = new JSONObject(caracteristicas1);		
			Iterator<String> keys = jsonObj.keys();		
			List<CaracteristicasDTO> caracteristicasDTO = new ArrayList<CaracteristicasDTO>();		
			while (keys.hasNext()) {
				String key = keys.next();		
				boolean isActive = jsonObj.getBoolean(key);		
				if (isActive) {	
					CaracteristicasDTO caracteristica = new CaracteristicasDTO();
					caracteristica.setCategoria(getIdCategoria());
					caracteristica.setValor(key);
					caracteristicasDTO.add(caracteristica);
				}		
			}
			this.caracteristicas = caracteristicasDTO;
		} catch (Exception e){e.printStackTrace();}
	}


	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
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

	public CategoryEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryEnum categoria) {
		this.categoria = categoria;
	}

	public AlimentacionDTO getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(AlimentacionDTO alimentacion) {
		this.alimentacion = alimentacion;
	}

	public AlojamientoDTO getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(AlojamientoDTO alojamiento) {
		this.alojamiento = alojamiento;
	}

	public PaseoEcologicoDTO getPaseoEcologico() {
		return paseoEcologico;
	}

	public void setPaseoEcologico(PaseoEcologicoDTO paseoEcologico) {
		this.paseoEcologico = paseoEcologico;
	}

	public TransporteDTO getTransporte() {
		return transporte;
	}

	public void setTransporte(TransporteDTO transporte) {
		this.transporte = transporte;
	}

	public static List<ServicioDTO> buildListObject(List<Servicio> listServicio) {
		List<ServicioDTO> listServicioDTO = new ArrayList<>();
		for (Servicio servicio : listServicio) {
			ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), servicio.getActivo(), servicio.getNombre(), servicio.getDescripcion(), String.valueOf(servicio.getPrecio()), servicio.getRestricciones());

			// TODO Mover esta lógica a un método
			String idCategoria = "";
			if (servicio.getAlimentacion() != null) {
				idCategoria = CategoryEnum.ALIMENTACION.getId();
			} else if (servicio.getTransporte() != null) {
				idCategoria = CategoryEnum.TRANSPORTE.getId();
			} else if (servicio.getAlojamiento() != null) {
				idCategoria = CategoryEnum.ALOJAMIENTO.getId();
			} else if (servicio.getPaseoEcologico() != null) {
				idCategoria = CategoryEnum.PASEO_ECOLOGICO.getId();
			}
			servicioDTO.setIdCategoria(idCategoria);
			servicioDTO.setCiudadFromCategoria(servicio);
			if(servicio.getImagenprincipal() != null){
				servicioDTO.setImagenPrincipal(new String(servicio.getImagenprincipal()));
			}

			listServicioDTO.add(servicioDTO);
		}
		return listServicioDTO;
	}

	public static ServicioDTO buildObject(Servicio servicio) {
		ServicioDTO servicioDTO = new ServicioDTO(servicio.getId(), servicio.getActivo(), servicio.getNombre(), servicio.getDescripcion(), String.valueOf(servicio.getPrecio()), servicio.getRestricciones());
		servicioDTO.setCiudadFromCategoria(servicio);
		if(servicio.getImagenprincipal() != null){
			servicioDTO.setImagenPrincipal(new String(servicio.getImagenprincipal()));
		}
		return servicioDTO;
	}

	private void setCiudadFromCategoria(Servicio servicio) {
		String ciudad = "";
		if (servicio.getAlimentacion() != null) {
			ciudad = servicio.getAlimentacion().getCiudad();
		} else if (servicio.getTransporte() != null) {
			ciudad = servicio.getTransporte().getLugardestino();
		} else if (servicio.getAlojamiento() != null) {
			ciudad = servicio.getAlojamiento().getCiudad();
		} else if (servicio.getPaseoEcologico() != null) {
			ciudad = servicio.getPaseoEcologico().getCiudad();
		}
		this.ciudad = ciudad;
	}

	public static List<ServicioDTO> buildListServicioDTO(List<PaqueteServicio> listaPaqueteServicio) {
		List<ServicioDTO> listaServicioDTO = new ArrayList<>();
		System.out.println("buildListServicioDTO");
		for (PaqueteServicio paqueteServicio : listaPaqueteServicio) {
			System.out.println(paqueteServicio.getServicio().getNombre());
			ServicioDTO servicioDTO = ServicioDTO.buildObject(paqueteServicio.getServicio());
			servicioDTO.setPaquete(servicioDTO.buildPaquete(paqueteServicio.getServicio()));
			listaServicioDTO.add(servicioDTO);
		}
		return listaServicioDTO;
	}

	private PaqueteDTO buildPaquete(Servicio servicio) {
		PaqueteDTO paquete = new PaqueteDTO();
		String idCategoria = "";
		if (servicio.getAlimentacion() != null) {
			idCategoria = CategoryEnum.ALIMENTACION.getId();
			paquete.setNombre(CategoryEnum.ALIMENTACION.name());
		} else if (servicio.getTransporte() != null) {
			idCategoria = CategoryEnum.TRANSPORTE.getId();
			paquete.setNombre(CategoryEnum.TRANSPORTE.name());
		} else if (servicio.getAlojamiento() != null) {
			idCategoria = CategoryEnum.ALOJAMIENTO.getId();
			paquete.setNombre(CategoryEnum.ALOJAMIENTO.name());
		} else if (servicio.getPaseoEcologico() != null) {
			idCategoria = CategoryEnum.PASEO_ECOLOGICO.getId();
			paquete.setNombre(CategoryEnum.PASEO_ECOLOGICO.name());
		}
		this.idCategoria = idCategoria;
		return paquete;
	}

}