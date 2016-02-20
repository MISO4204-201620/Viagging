package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_pregunta database table.
 * 
 */
@Entity
@Table(name="tr_pregunta")
@NamedQuery(name="TrPregunta.findAll", query="SELECT t FROM TrPregunta t")
public class TrPregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String pregunta;

	private String respuesta;

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

	public TrPregunta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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