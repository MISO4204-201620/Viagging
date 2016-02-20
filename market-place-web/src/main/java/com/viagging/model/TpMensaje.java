package com.viagging.model;

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
@NamedQuery(name="TpMensaje.findAll", query="SELECT t FROM TpMensaje t")
public class TpMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String mensaje;

	//bi-directional many-to-one association to TpMensaje
	@ManyToOne
	@JoinColumn(name="idmensajepadre")
	private TpMensaje tpMensaje;

	//bi-directional many-to-one association to TpMensaje
	@OneToMany(mappedBy="tpMensaje")
	private List<TpMensaje> tpMensajes;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idconversacion")
	private TpUsuario tpUsuario;

	public TpMensaje() {
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

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public TpMensaje getTpMensaje() {
		return this.tpMensaje;
	}

	public void setTpMensaje(TpMensaje tpMensaje) {
		this.tpMensaje = tpMensaje;
	}

	public List<TpMensaje> getTpMensajes() {
		return this.tpMensajes;
	}

	public void setTpMensajes(List<TpMensaje> tpMensajes) {
		this.tpMensajes = tpMensajes;
	}

	public TpMensaje addTpMensaje(TpMensaje tpMensaje) {
		getTpMensajes().add(tpMensaje);
		tpMensaje.setTpMensaje(this);

		return tpMensaje;
	}

	public TpMensaje removeTpMensaje(TpMensaje tpMensaje) {
		getTpMensajes().remove(tpMensaje);
		tpMensaje.setTpMensaje(null);

		return tpMensaje;
	}

	public TpUsuario getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

}