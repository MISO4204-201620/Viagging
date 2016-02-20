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
@NamedQuery(name="TrAlojamiento.findAll", query="SELECT t FROM TrAlojamiento t")
public class TrAlojamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String numerohabitaciones;

	private String numeromayores;

	private String numeromenores;

	private Integer precio;

	//bi-directional many-to-one association to TpServicio
	@OneToMany(mappedBy="trAlojamiento")
	private List<TpServicio> tpServicios;

	public TrAlojamiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumerohabitaciones() {
		return this.numerohabitaciones;
	}

	public void setNumerohabitaciones(String numerohabitaciones) {
		this.numerohabitaciones = numerohabitaciones;
	}

	public String getNumeromayores() {
		return this.numeromayores;
	}

	public void setNumeromayores(String numeromayores) {
		this.numeromayores = numeromayores;
	}

	public String getNumeromenores() {
		return this.numeromenores;
	}

	public void setNumeromenores(String numeromenores) {
		this.numeromenores = numeromenores;
	}

	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public List<TpServicio> getTpServicios() {
		return this.tpServicios;
	}

	public void setTpServicios(List<TpServicio> tpServicios) {
		this.tpServicios = tpServicios;
	}

	public TpServicio addTpServicio(TpServicio tpServicio) {
		getTpServicios().add(tpServicio);
		tpServicio.setTrAlojamiento(this);

		return tpServicio;
	}

	public TpServicio removeTpServicio(TpServicio tpServicio) {
		getTpServicios().remove(tpServicio);
		tpServicio.setTrAlojamiento(null);

		return tpServicio;
	}

}