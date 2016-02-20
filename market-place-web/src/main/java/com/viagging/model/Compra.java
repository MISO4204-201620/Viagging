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
@NamedQuery(name="Compra.findAll", query="SELECT t FROM Compra t")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fechaCompra;

	//bi-directional many-to-one association to ComentarioCalificacion
	@OneToMany(mappedBy="compra")
	private List<ComentarioCalificacion> comentarioCalificacion;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="idpaquete")
	private Paquete paquete;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Compra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public List<ComentarioCalificacion> getComentarioCalificacion() {
		return this.comentarioCalificacion;
	}

	public void setComentarioCalificacion(List<ComentarioCalificacion> comentarioCalificacion) {
		this.comentarioCalificacion = comentarioCalificacion;
	}

	public ComentarioCalificacion addComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().add(comentarioCalificacion);
		comentarioCalificacion.setCompra(this);

		return comentarioCalificacion;
	}

	public ComentarioCalificacion removeComentarioCalificacion(ComentarioCalificacion comentarioCalificacion) {
		getComentarioCalificacion().remove(comentarioCalificacion);
		comentarioCalificacion.setCompra(null);

		return comentarioCalificacion;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}