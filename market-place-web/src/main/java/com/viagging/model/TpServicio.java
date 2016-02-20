package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tp_servicio database table.
 * 
 */
@Entity
@Table(name="tp_servicio")
@NamedQuery(name="TpServicio.findAll", query="SELECT t FROM TpServicio t")
public class TpServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean activo;

	private Boolean datosservicio;

	private String nombre;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private TpUsuario tpUsuario;

	//bi-directional many-to-one association to TrAlimentacion
	@ManyToOne
	@JoinColumn(name="idalimentacion")
	private TrAlimentacion trAlimentacion;

	//bi-directional many-to-one association to TrAlojamiento
	@ManyToOne
	@JoinColumn(name="idalojamiento")
	private TrAlojamiento trAlojamiento;

	//bi-directional many-to-one association to TrPaseosecologico
	@ManyToOne
	@JoinColumn(name="idpaseosecologicos")
	private TrPaseosecologico trPaseosecologico;

	//bi-directional many-to-one association to TrTransporte
	@ManyToOne
	@JoinColumn(name="idtransporte")
	private TrTransporte trTransporte;

	//bi-directional many-to-one association to TrComentarioCalificacion
	@OneToMany(mappedBy="tpServicio")
	private List<TrComentarioCalificacion> trComentarioCalificacions;

	//bi-directional many-to-one association to TrCompra
	@OneToMany(mappedBy="tpServicio")
	private List<TrCompra> trCompras;

	//bi-directional many-to-one association to TrMovimiento
	@OneToMany(mappedBy="tpServicio")
	private List<TrMovimiento> trMovimientos;

	//bi-directional many-to-one association to TrPaqueteservicio
	@OneToMany(mappedBy="tpServicio")
	private List<TrPaqueteservicio> trPaqueteservicios;

	//bi-directional many-to-one association to TrPregunta
	@OneToMany(mappedBy="tpServicio")
	private List<TrPregunta> trPreguntas;

	public TpServicio() {
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

	public Boolean getDatosservicio() {
		return this.datosservicio;
	}

	public void setDatosservicio(Boolean datosservicio) {
		this.datosservicio = datosservicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TpUsuario getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

	public TrAlimentacion getTrAlimentacion() {
		return this.trAlimentacion;
	}

	public void setTrAlimentacion(TrAlimentacion trAlimentacion) {
		this.trAlimentacion = trAlimentacion;
	}

	public TrAlojamiento getTrAlojamiento() {
		return this.trAlojamiento;
	}

	public void setTrAlojamiento(TrAlojamiento trAlojamiento) {
		this.trAlojamiento = trAlojamiento;
	}

	public TrPaseosecologico getTrPaseosecologico() {
		return this.trPaseosecologico;
	}

	public void setTrPaseosecologico(TrPaseosecologico trPaseosecologico) {
		this.trPaseosecologico = trPaseosecologico;
	}

	public TrTransporte getTrTransporte() {
		return this.trTransporte;
	}

	public void setTrTransporte(TrTransporte trTransporte) {
		this.trTransporte = trTransporte;
	}

	public List<TrComentarioCalificacion> getTrComentarioCalificacions() {
		return this.trComentarioCalificacions;
	}

	public void setTrComentarioCalificacions(List<TrComentarioCalificacion> trComentarioCalificacions) {
		this.trComentarioCalificacions = trComentarioCalificacions;
	}

	public TrComentarioCalificacion addTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().add(trComentarioCalificacion);
		trComentarioCalificacion.setTpServicio(this);

		return trComentarioCalificacion;
	}

	public TrComentarioCalificacion removeTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().remove(trComentarioCalificacion);
		trComentarioCalificacion.setTpServicio(null);

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
		trCompra.setTpServicio(this);

		return trCompra;
	}

	public TrCompra removeTrCompra(TrCompra trCompra) {
		getTrCompras().remove(trCompra);
		trCompra.setTpServicio(null);

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
		trMovimiento.setTpServicio(this);

		return trMovimiento;
	}

	public TrMovimiento removeTrMovimiento(TrMovimiento trMovimiento) {
		getTrMovimientos().remove(trMovimiento);
		trMovimiento.setTpServicio(null);

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
		trPaqueteservicio.setTpServicio(this);

		return trPaqueteservicio;
	}

	public TrPaqueteservicio removeTrPaqueteservicio(TrPaqueteservicio trPaqueteservicio) {
		getTrPaqueteservicios().remove(trPaqueteservicio);
		trPaqueteservicio.setTpServicio(null);

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
		trPregunta.setTpServicio(this);

		return trPregunta;
	}

	public TrPregunta removeTrPregunta(TrPregunta trPregunta) {
		getTrPreguntas().remove(trPregunta);
		trPregunta.setTpServicio(null);

		return trPregunta;
	}

}