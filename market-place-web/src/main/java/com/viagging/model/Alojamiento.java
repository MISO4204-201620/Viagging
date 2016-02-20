package com.viagging.model;

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

	private String numeroHabitaciones;

	private String numeroMayores;

	private String numeroMenores;

	private Integer precio;

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

	public String getNumeroHabitaciones() {
		return this.numeroHabitaciones;
	}

	public void setNumeroHabitaciones(String numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public String getNumeroMayores() {
		return this.numeroMayores;
	}

	public void setNumeromayores(String numeroMayores) {
		this.numeroMayores = numeroMayores;
	}

	public String getNumeromenores() {
		return this.numeroMenores;
	}

	public void setNumeromenores(String numeroMenores) {
		this.numeroMenores = numeroMenores;
	}

	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
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