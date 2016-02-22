package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tp_servicio database table.
 * 
 */
@Entity
@Table(name="tp_servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT t FROM Servicio t")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean activo;

	private Boolean datosServicio;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Alimentacion
	@ManyToOne
	@JoinColumn(name="idalimentacion")
	private Alimentacion alimentacion;

	//bi-directional many-to-one association to Alojamiento
	@ManyToOne
	@JoinColumn(name="idalojamiento")
	private Alojamiento alojamiento;

	//bi-directional many-to-one association to PaseoEcologico
	@ManyToOne
	@JoinColumn(name="idpaseosecologicos")
	private PaseoEcologico paseoEcologico;

	//bi-directional many-to-one association to Transporte
	@ManyToOne
	@JoinColumn(name="idtransporte")
	private Transporte transporte;

	//bi-directional many-to-one association to ComentarioCalificacion
	@OneToMany(mappedBy="servicio")
	private List<ComentarioCalificacion> comentarioCalificacion;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="servicio")
	private List<Compra> compras;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="servicio")
	private List<Movimiento> movimientos;

	//bi-directional many-to-one association to PaqueteServicio
	@OneToMany(mappedBy="servicio")
	private List<PaqueteServicio> paqueteServicios;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="servicio")
	private List<Pregunta> preguntas;

	public Servicio() {
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

	public Boolean getDatosServicio() {
		return this.datosServicio;
	}

	public void setDatosServicio(Boolean datosServicio) {
		this.datosServicio = datosServicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Alimentacion getAlimentacion() {
		return this.alimentacion;
	}

	public void setAlimentacion(Alimentacion alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public PaseoEcologico getPaseoEcologico() {
		return this.paseoEcologico;
	}

	public void setPaseoEcologico(PaseoEcologico paseoEcologico) {
		this.paseoEcologico = paseoEcologico;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public List<ComentarioCalificacion> getComentarioCalificacion() {
		return this.comentarioCalificacion;
	}

	public void setComentarioCalificacion(List<ComentarioCalificacion> comentarioCalificacion) {
		this.comentarioCalificacion = comentarioCalificacion;
	}

	public ComentarioCalificacion addComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().add(comentarioCalificacion);
		comentarioCalificacion.setServicio(this);

		return comentarioCalificacion;
	}

	public ComentarioCalificacion removeComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().remove(comentarioCalificacion);
		comentarioCalificacion.setServicio(null);

		return comentarioCalificacion;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setServicio(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setServicio(null);

		return compra;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setServicio(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setServicio(null);

		return movimiento;
	}

	public List<PaqueteServicio> getPaqueteServicios() {
		return this.paqueteServicios;
	}

	public void setPaqueteServicios(List<PaqueteServicio> paqueteServicios) {
		this.paqueteServicios = paqueteServicios;
	}

	public PaqueteServicio addPaqueteServicio(PaqueteServicio paqueteServicio) {
		getPaqueteServicios().add(paqueteServicio);
		paqueteServicio.setServicio(this);

		return paqueteServicio;
	}

	public PaqueteServicio removePaqueteServicio(PaqueteServicio paqueteServicio) {
		getPaqueteServicios().remove(paqueteServicio);
		paqueteServicio.setServicio(null);

		return paqueteServicio;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setServicio(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setServicio(null);

		return pregunta;
	}

}