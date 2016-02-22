package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tp_conversacion database table.
 * 
 */
@Entity
@Table(name="tp_conversacion")
@NamedQuery(name="Conversacion.findAll", query="SELECT t FROM Conversacion t")
public class Conversacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fechaUltimoMensaje;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariouno")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariodos")
	private Usuario usuario2;

	public Conversacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaUltimoMensaje() {
		return this.fechaUltimoMensaje;
	}

	public void setFechaUltimoMensaje(Date fechaUltimoMensaje) {
		this.fechaUltimoMensaje = fechaUltimoMensaje;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}