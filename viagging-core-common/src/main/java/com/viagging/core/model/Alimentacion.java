package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tr_alimentacion database table.
 * 
 */
@Entity
@Table(name="tr_alimentacion")
@NamedQuery(name="Alimentacion.findAll", query="SELECT t FROM Alimentacion t")
public class Alimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String caracteristicas;

	private String ciudad;

	private String horarioapertura;
	
	private String horariocierre;

	private byte[] imagenprincipal;

	private Integer preciomayor;

	private Integer preciomenor;

	private String restricciones;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="alimentacion")
	private List<Servicio> servicios;

	public Alimentacion() {
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

	public String getHorarioapertura() {
		return horarioapertura;
	}

	public void setHorarioapertura(String horarioapertura) {
		this.horarioapertura = horarioapertura;
	}

	public byte[] getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(byte[] imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public Integer getPreciomayor() {
		return preciomayor;
	}

	public void setPreciomayor(Integer preciomayor) {
		this.preciomayor = preciomayor;
	}

	public Integer getPreciomenor() {
		return preciomenor;
	}

	public void setPreciomenor(Integer preciomenor) {
		this.preciomenor = preciomenor;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}
	
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setAlimentacion(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setAlimentacion(null);

		return servicio;
	}

	public String getHorariocierre() {
		return horariocierre;
	}

	public void setHorariocierre(String horariocierre) {
		this.horariocierre = horariocierre;
	}

}