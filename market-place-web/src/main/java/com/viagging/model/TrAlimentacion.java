package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tr_alimentacion database table.
 * 
 */
@Entity
@Table(name="tr_alimentacion")
@NamedQuery(name="TrAlimentacion.findAll", query="SELECT t FROM TrAlimentacion t")
public class TrAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String almuerzo;

	private String cena;

	private String desayuno;

	private Integer precio;

	//bi-directional many-to-one association to TpServicio
	@OneToMany(mappedBy="trAlimentacion")
	private List<TpServicio> tpServicios;

	public TrAlimentacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlmuerzo() {
		return this.almuerzo;
	}

	public void setAlmuerzo(String almuerzo) {
		this.almuerzo = almuerzo;
	}

	public String getCena() {
		return this.cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getDesayuno() {
		return this.desayuno;
	}

	public void setDesayuno(String desayuno) {
		this.desayuno = desayuno;
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
		tpServicio.setTrAlimentacion(this);

		return tpServicio;
	}

	public TpServicio removeTpServicio(TpServicio tpServicio) {
		getTpServicios().remove(tpServicio);
		tpServicio.setTrAlimentacion(null);

		return tpServicio;
	}

}