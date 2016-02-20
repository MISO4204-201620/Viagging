package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tr_movimiento database table.
 * 
 */
@Entity
@Table(name="tr_movimiento")
@NamedQuery(name="TrMovimiento.findAll", query="SELECT t FROM TrMovimiento t")
public class TrMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String accion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to TpPaquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private TpPaquete tpPaquete;

	//bi-directional many-to-one association to TpServicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private TpServicio tpServicio;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private TpUsuario tpUsuario;

	public TrMovimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public TpUsuario getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

}