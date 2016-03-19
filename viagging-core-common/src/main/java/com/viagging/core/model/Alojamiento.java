package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tr_alojamiento database table.
 * 
 */
@Entity
@Table(name="tr_alojamiento")
@NamedQuery(name="Alojamiento.findAll", query="SELECT t FROM Alojamiento t")
public class Alojamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String caracteristicas;

	private String ciudad;

	private byte[] imagenprincipal;

	private String restricciones;

	private Integer valorpornoche;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="alojamiento")
	private List<Servicio> servicios;

	public Alojamiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public byte[] getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(byte[] imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public Integer getValorpornoche() {
		return valorpornoche;
	}

	public void setValorpornoche(Integer valorpornoche) {
		this.valorpornoche = valorpornoche;
	}
	
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setAlojamiento(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setAlojamiento(null);

		return servicio;
	}

}