package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tp_paquete database table.
 * 
 */
@Entity
@Table(name="tp_paquete")
@NamedQuery(name="TpPaquete.findAll", query="SELECT t FROM TpPaquete t")
public class TpPaquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean activo;

	private String nombrepaquete;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private TpUsuario tpUsuario;

	//bi-directional many-to-one association to TrComentarioCalificacion
	@OneToMany(mappedBy="tpPaquete")
	private List<TrComentarioCalificacion> trComentarioCalificacions;

	//bi-directional many-to-one association to TrCompra
	@OneToMany(mappedBy="tpPaquete")
	private List<TrCompra> trCompras;

	//bi-directional many-to-one association to TrMovimiento
	@OneToMany(mappedBy="tpPaquete")
	private List<TrMovimiento> trMovimientos;

	//bi-directional many-to-one association to TrPaqueteservicio
	@OneToMany(mappedBy="tpPaquete")
	private List<TrPaqueteservicio> trPaqueteservicios;

	//bi-directional many-to-one association to TrPregunta
	@OneToMany(mappedBy="tpPaquete")
	private List<TrPregunta> trPreguntas;

	public TpPaquete() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombrepaquete() {
		return this.nombrepaquete;
	}

	public void setNombrepaquete(String nombrepaquete) {
		this.nombrepaquete = nombrepaquete;
	}

	public TpUsuario getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

	public List<TrComentarioCalificacion> getTrComentarioCalificacions() {
		return this.trComentarioCalificacions;
	}

	public void setTrComentarioCalificacions(List<TrComentarioCalificacion> trComentarioCalificacions) {
		this.trComentarioCalificacions = trComentarioCalificacions;
	}

	public TrComentarioCalificacion addTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().add(trComentarioCalificacion);
		trComentarioCalificacion.setTpPaquete(this);

		return trComentarioCalificacion;
	}

	public TrComentarioCalificacion removeTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().remove(trComentarioCalificacion);
		trComentarioCalificacion.setTpPaquete(null);

		return trComentarioCalificacion;
	}

	public List<TrCompra> getTrCompras() {
		return this.trCompras;
	}

	public void setTrCompras(List<TrCompra> trCompras) {
		this.trCompras = trCompras;
	}

	public TrCompra addTrCompra(TrCompra trCompra) {
		getTrCompras().add(trCompra);
		trCompra.setTpPaquete(this);

		return trCompra;
	}

	public TrCompra removeTrCompra(TrCompra trCompra) {
		getTrCompras().remove(trCompra);
		trCompra.setTpPaquete(null);

		return trCompra;
	}

	public List<TrMovimiento> getTrMovimientos() {
		return this.trMovimientos;
	}

	public void setTrMovimientos(List<TrMovimiento> trMovimientos) {
		this.trMovimientos = trMovimientos;
	}

	public TrMovimiento addTrMovimiento(TrMovimiento trMovimiento) {
		getTrMovimientos().add(trMovimiento);
		trMovimiento.setTpPaquete(this);

		return trMovimiento;
	}

	public TrMovimiento removeTrMovimiento(TrMovimiento trMovimiento) {
		getTrMovimientos().remove(trMovimiento);
		trMovimiento.setTpPaquete(null);

		return trMovimiento;
	}

	public List<TrPaqueteservicio> getTrPaqueteservicios() {
		return this.trPaqueteservicios;
	}

	public void setTrPaqueteservicios(List<TrPaqueteservicio> trPaqueteservicios) {
		this.trPaqueteservicios = trPaqueteservicios;
	}

	public TrPaqueteservicio addTrPaqueteservicio(TrPaqueteservicio trPaqueteservicio) {
		getTrPaqueteservicios().add(trPaqueteservicio);
		trPaqueteservicio.setTpPaquete(this);

		return trPaqueteservicio;
	}

	public TrPaqueteservicio removeTrPaqueteservicio(TrPaqueteservicio trPaqueteservicio) {
		getTrPaqueteservicios().remove(trPaqueteservicio);
		trPaqueteservicio.setTpPaquete(null);

		return trPaqueteservicio;
	}

	public List<TrPregunta> getTrPreguntas() {
		return this.trPreguntas;
	}

	public void setTrPreguntas(List<TrPregunta> trPreguntas) {
		this.trPreguntas = trPreguntas;
	}

	public TrPregunta addTrPregunta(TrPregunta trPregunta) {
		getTrPreguntas().add(trPregunta);
		trPregunta.setTpPaquete(this);

		return trPregunta;
	}

	public TrPregunta removeTrPregunta(TrPregunta trPregunta) {
		getTrPreguntas().remove(trPregunta);
		trPregunta.setTpPaquete(null);

		return trPregunta;
	}

}