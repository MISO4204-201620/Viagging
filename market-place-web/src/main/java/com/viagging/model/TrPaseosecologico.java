package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tr_paseosecologicos database table.
 * 
 */
@Entity
@Table(name="tr_paseosecologicos")
@NamedQuery(name="TrPaseosecologico.findAll", query="SELECT t FROM TrPaseosecologico t")
public class TrPaseosecologico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String lugar;

	private String nombre;

	private Integer precio;

	//bi-directional many-to-one association to TpServicio
	@OneToMany(mappedBy="trPaseosecologico")
	private List<TpServicio> tpServicios;

	public TrPaseosecologico() {
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
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
		tpServicio.setTrPaseosecologico(this);

		return tpServicio;
	}

	public TpServicio removeTpServicio(TpServicio tpServicio) {
		getTpServicios().remove(tpServicio);
		tpServicio.setTrPaseosecologico(null);

		return tpServicio;
	}

}