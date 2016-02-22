package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tp_mensaje database table.
 * 
 */
@Entity
@Table(name="tp_mensaje")
@NamedQuery(name="Mensaje.findAll", query="SELECT t FROM Mensaje t")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String texto;

	//bi-directional many-to-one association to Mensaje
	@ManyToOne
	@JoinColumn(name="idmensajepadre")
	private Mensaje mensaje;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="mensaje")
	private List<Mensaje> mensajes;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idconversacion")
	private Usuario usuario;

	public Mensaje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Mensaje getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setMensaje(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setMensaje(null);

		return mensaje;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}