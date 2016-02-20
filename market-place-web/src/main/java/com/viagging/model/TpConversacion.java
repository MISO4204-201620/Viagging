package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tp_conversacion database table.
 * 
 */
@Entity
@Table(name="tp_conversacion")
@NamedQuery(name="TpConversacion.findAll", query="SELECT t FROM TpConversacion t")
public class TpConversacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fechaultimomensaje;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuariouno")
	private TpUsuario tpUsuario1;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuariodos")
	private TpUsuario tpUsuario2;

	public TpConversacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaultimomensaje() {
		return this.fechaultimomensaje;
	}

	public void setFechaultimomensaje(Date fechaultimomensaje) {
		this.fechaultimomensaje = fechaultimomensaje;
	}

	public TpUsuario getTpUsuario1() {
		return this.tpUsuario1;
	}

	public void setTpUsuario1(TpUsuario tpUsuario1) {
		this.tpUsuario1 = tpUsuario1;
	}

	public TpUsuario getTpUsuario2() {
		return this.tpUsuario2;
	}

	public void setTpUsuario2(TpUsuario tpUsuario2) {
		this.tpUsuario2 = tpUsuario2;
	}

}