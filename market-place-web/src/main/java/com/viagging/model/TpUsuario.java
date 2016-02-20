package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tp_usuario database table.
 * 
 */
@Entity
@Table(name="tp_usuario")
@NamedQuery(name="TpUsuario.findAll", query="SELECT t FROM TpUsuario t")
public class TpUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String correo;

	private Integer numerocelular;

	private Integer numerodocumento;

	private String primerapellido;

	private String primernombre;

	private String segundoapellido;

	private String segundonombre;

	private String tipodocumento;

	//bi-directional many-to-one association to TpConversacion
	@OneToMany(mappedBy="tpUsuario1")
	private List<TpConversacion> tpConversacions1;

	//bi-directional many-to-one association to TpConversacion
	@OneToMany(mappedBy="tpUsuario2")
	private List<TpConversacion> tpConversacions2;

	//bi-directional many-to-one association to TpMensaje
	@OneToMany(mappedBy="tpUsuario")
	private List<TpMensaje> tpMensajes;

	//bi-directional many-to-one association to TpPaquete
	@OneToMany(mappedBy="tpUsuario")
	private List<TpPaquete> tpPaquetes;

	//bi-directional many-to-one association to TpServicio
	@OneToMany(mappedBy="tpUsuario")
	private List<TpServicio> tpServicios;

	//bi-directional many-to-one association to TrComentarioCalificacion
	@OneToMany(mappedBy="tpUsuario")
	private List<TrComentarioCalificacion> trComentarioCalificacions;

	//bi-directional many-to-one association to TrCompra
	@OneToMany(mappedBy="tpUsuario")
	private List<TrCompra> trCompras;

	//bi-directional many-to-one association to TrCuentaacceso
	@OneToMany(mappedBy="tpUsuario")
	private List<TrCuentaacceso> trCuentaaccesos;

	//bi-directional many-to-one association to TrMovimiento
	@OneToMany(mappedBy="tpUsuario")
	private List<TrMovimiento> trMovimientos;

	//bi-directional many-to-one association to TrPregunta
	@OneToMany(mappedBy="tpUsuario")
	private List<TrPregunta> trPreguntas;

	public TpUsuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getNumerocelular() {
		return this.numerocelular;
	}

	public void setNumerocelular(Integer numerocelular) {
		this.numerocelular = numerocelular;
	}

	public Integer getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(Integer numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getPrimerapellido() {
		return this.primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getPrimernombre() {
		return this.primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public String getSegundoapellido() {
		return this.segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getSegundonombre() {
		return this.segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public List<TpConversacion> getTpConversacions1() {
		return this.tpConversacions1;
	}

	public void setTpConversacions1(List<TpConversacion> tpConversacions1) {
		this.tpConversacions1 = tpConversacions1;
	}

	public TpConversacion addTpConversacions1(TpConversacion tpConversacions1) {
		getTpConversacions1().add(tpConversacions1);
		tpConversacions1.setTpUsuario1(this);

		return tpConversacions1;
	}

	public TpConversacion removeTpConversacions1(TpConversacion tpConversacions1) {
		getTpConversacions1().remove(tpConversacions1);
		tpConversacions1.setTpUsuario1(null);

		return tpConversacions1;
	}

	public List<TpConversacion> getTpConversacions2() {
		return this.tpConversacions2;
	}

	public void setTpConversacions2(List<TpConversacion> tpConversacions2) {
		this.tpConversacions2 = tpConversacions2;
	}

	public TpConversacion addTpConversacions2(TpConversacion tpConversacions2) {
		getTpConversacions2().add(tpConversacions2);
		tpConversacions2.setTpUsuario2(this);

		return tpConversacions2;
	}

	public TpConversacion removeTpConversacions2(TpConversacion tpConversacions2) {
		getTpConversacions2().remove(tpConversacions2);
		tpConversacions2.setTpUsuario2(null);

		return tpConversacions2;
	}

	public List<TpMensaje> getTpMensajes() {
		return this.tpMensajes;
	}

	public void setTpMensajes(List<TpMensaje> tpMensajes) {
		this.tpMensajes = tpMensajes;
	}

	public TpMensaje addTpMensaje(TpMensaje tpMensaje) {
		getTpMensajes().add(tpMensaje);
		tpMensaje.setTpUsuario(this);

		return tpMensaje;
	}

	public TpMensaje removeTpMensaje(TpMensaje tpMensaje) {
		getTpMensajes().remove(tpMensaje);
		tpMensaje.setTpUsuario(null);

		return tpMensaje;
	}

	public List<TpPaquete> getTpPaquetes() {
		return this.tpPaquetes;
	}

	public void setTpPaquetes(List<TpPaquete> tpPaquetes) {
		this.tpPaquetes = tpPaquetes;
	}

	public TpPaquete addTpPaquete(TpPaquete tpPaquete) {
		getTpPaquetes().add(tpPaquete);
		tpPaquete.setTpUsuario(this);

		return tpPaquete;
	}

	public TpPaquete removeTpPaquete(TpPaquete tpPaquete) {
		getTpPaquetes().remove(tpPaquete);
		tpPaquete.setTpUsuario(null);

		return tpPaquete;
	}

	public List<TpServicio> getTpServicios() {
		return this.tpServicios;
	}

	public void setTpServicios(List<TpServicio> tpServicios) {
		this.tpServicios = tpServicios;
	}

	public TpServicio addTpServicio(TpServicio tpServicio) {
		getTpServicios().add(tpServicio);
		tpServicio.setTpUsuario(this);

		return tpServicio;
	}

	public TpServicio removeTpServicio(TpServicio tpServicio) {
		getTpServicios().remove(tpServicio);
		tpServicio.setTpUsuario(null);

		return tpServicio;
	}

	public List<TrComentarioCalificacion> getTrComentarioCalificacions() {
		return this.trComentarioCalificacions;
	}

	public void setTrComentarioCalificacions(List<TrComentarioCalificacion> trComentarioCalificacions) {
		this.trComentarioCalificacions = trComentarioCalificacions;
	}

	public TrComentarioCalificacion addTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().add(trComentarioCalificacion);
		trComentarioCalificacion.setTpUsuario(this);

		return trComentarioCalificacion;
	}

	public TrComentarioCalificacion removeTrComentarioCalificacion(TrComentarioCalificacion trComentarioCalificacion) {
		getTrComentarioCalificacions().remove(trComentarioCalificacion);
		trComentarioCalificacion.setTpUsuario(null);

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
		trCompra.setTpUsuario(this);

		return trCompra;
	}

	public TrCompra removeTrCompra(TrCompra trCompra) {
		getTrCompras().remove(trCompra);
		trCompra.setTpUsuario(null);

		return trCompra;
	}

	public List<TrCuentaacceso> getTrCuentaaccesos() {
		return this.trCuentaaccesos;
	}

	public void setTrCuentaaccesos(List<TrCuentaacceso> trCuentaaccesos) {
		this.trCuentaaccesos = trCuentaaccesos;
	}

	public TrCuentaacceso addTrCuentaacceso(TrCuentaacceso trCuentaacceso) {
		getTrCuentaaccesos().add(trCuentaacceso);
		trCuentaacceso.setTpUsuario(this);

		return trCuentaacceso;
	}

	public TrCuentaacceso removeTrCuentaacceso(TrCuentaacceso trCuentaacceso) {
		getTrCuentaaccesos().remove(trCuentaacceso);
		trCuentaacceso.setTpUsuario(null);

		return trCuentaacceso;
	}

	public List<TrMovimiento> getTrMovimientos() {
		return this.trMovimientos;
	}

	public void setTrMovimientos(List<TrMovimiento> trMovimientos) {
		this.trMovimientos = trMovimientos;
	}

	public TrMovimiento addTrMovimiento(TrMovimiento trMovimiento) {
		getTrMovimientos().add(trMovimiento);
		trMovimiento.setTpUsuario(this);

		return trMovimiento;
	}

	public TrMovimiento removeTrMovimiento(TrMovimiento trMovimiento) {
		getTrMovimientos().remove(trMovimiento);
		trMovimiento.setTpUsuario(null);

		return trMovimiento;
	}

	public List<TrPregunta> getTrPreguntas() {
		return this.trPreguntas;
	}

	public void setTrPreguntas(List<TrPregunta> trPreguntas) {
		this.trPreguntas = trPreguntas;
	}

	public TrPregunta addTrPregunta(TrPregunta trPregunta) {
		getTrPreguntas().add(trPregunta);
		trPregunta.setTpUsuario(this);

		return trPregunta;
	}

	public TrPregunta removeTrPregunta(TrPregunta trPregunta) {
		getTrPreguntas().remove(trPregunta);
		trPregunta.setTpUsuario(null);

		return trPregunta;
	}

}