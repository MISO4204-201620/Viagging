package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tr_transporte database table.
 * 
 */
@Entity
@Table(name="tr_transporte")
@NamedQuery(name="TrTransporte.findAll", query="SELECT t FROM TrTransporte t")
public class TrTransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String nombre;

	private Integer precio;

	//bi-directional many-to-one association to TpServicio
	@OneToMany(mappedBy="trTransporte")
	private List<TpServicio> tpServicios;

	public TrTransporte() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		tpServicio.setTrTransporte(this);

		return tpServicio;
	}

	public TpServicio removeTpServicio(TpServicio tpServicio) {
		getTpServicios().remove(tpServicio);
		tpServicio.setTrTransporte(null);

		return tpServicio;
	}

}