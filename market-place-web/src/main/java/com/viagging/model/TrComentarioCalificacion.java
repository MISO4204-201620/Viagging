package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tr_comentario_calificacion database table.
 * 
 */
@Entity
@Table(name="tr_comentario_calificacion")
@NamedQuery(name="TrComentarioCalificacion.findAll", query="SELECT t FROM TrComentarioCalificacion t")
public class TrComentarioCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private double calificacion;

	private String comentario;

	@Temporal(TemporalType.DATE)
	private Date fecharegistro;

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

	//bi-directional many-to-one association to TrCompra
	@ManyToOne
	@JoinColumn(name="idcompra")
	private TrCompra trCompra;

	public TrComentarioCalificacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
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

	public TrCompra getTrCompra() {
		return this.trCompra;
	}

	public void setTrCompra(TrCompra trCompra) {
		this.trCompra = trCompra;
	}

}