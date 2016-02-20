package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tr_compra database table.
 * 
 */
@Entity
@Table(name="tr_compra")
@NamedQuery(name="TrCompra.findAll", query="SELECT t FROM TrCompra t")
public class TrCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fechacompra;

	//bi-directional many-to-one association to TrComentarioCalificacion
	@OneToMany(mappedBy="trCompra")
	private List<TrComentarioCalificacion> trComentarioCalificacions;

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

	public TrCompra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechacompra() {
		return this.fechacompra;
	}

	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}

	public List<TrComentarioCalificacion> getTrComentarioCalificacions() {
		return this.trComentarioCalificacions;
	}

	public void setTrComentarioCalificacions(List<TrComentarioCalificacion> trComentarioCalificacions) {
		this.trComentarioCalificacions = trComentarioCalificacions;
	}

	public TrComentarioCalificacion addTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().add(trComentarioCalificacion);
		trComentarioCalificacion.setTrCompra(this);

		return trComentarioCalificacion;
	}

	public TrComentarioCalificacion removeTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().remove(trComentarioCalificacion);
		trComentarioCalificacion.setTrCompra(null);

		return trComentarioCalificacion;
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