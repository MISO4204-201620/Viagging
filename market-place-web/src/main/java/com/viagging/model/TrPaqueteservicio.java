package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_paqueteservicio database table.
 * 
 */
@Entity
@Table(name="tr_paqueteservicio")
@NamedQuery(name="TrPaqueteservicio.findAll", query="SELECT t FROM TrPaqueteservicio t")
public class TrPaqueteservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to TpPaquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private TpPaquete tpPaquete;

	//bi-directional many-to-one association to TpServicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private TpServicio tpServicio;

	public TrPaqueteservicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TpPaquete getTpPaquete() {
		return this.tpPaquete;
	}

	public void setTpPaquete(TpPaquete tpPaquete) {
		this.tpPaquete = tpPaquete;
	}

	public TpServicio getTpServicio() {
		return this.tpServicio;
	}

	public void setTpServicio(TpServicio tpServicio) {
		this.tpServicio = tpServicio;
	}

}