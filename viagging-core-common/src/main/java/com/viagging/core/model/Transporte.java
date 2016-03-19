package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tr_transporte database table.
 * 
 */
@Entity
@Table(name="tr_transporte")
@NamedQuery(name="Transporte.findAll", query="SELECT t FROM Transporte t")
public class Transporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String frecuenciasalida;

	private String horariofin;

	private String horarioinicio;

	private byte[] imagenprincipal;

	private String lugardestino;

	private String lugarorigen;

	private Integer numeropasajeros;

	private String restricciones;

	private String tiempoestimado;

	private String tipotransporte;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="transporte")
	private List<Servicio> servicios;

	public Transporte() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
  
	public String getFrecuenciasalida() {
		return frecuenciasalida;
	}

	public void setFrecuenciasalida(String frecuenciasalida) {
		this.frecuenciasalida = frecuenciasalida;
	}

	public String getHorariofin() {
		return horariofin;
	}

	public void setHorariofin(String horariofin) {
		this.horariofin = horariofin;
	}

	public String getHorarioinicio() {
		return horarioinicio;
	}

	public void setHorarioinicio(String horarioinicio) {
		this.horarioinicio = horarioinicio;
	}

	public byte[] getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(byte[] imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public String getLugardestino() {
		return lugardestino;
	}

	public void setLugardestino(String lugardestino) {
		this.lugardestino = lugardestino;
	}

	public String getLugarorigen() {
		return lugarorigen;
	}

	public void setLugarorigen(String lugarorigen) {
		this.lugarorigen = lugarorigen;
	}

	public Integer getNumeropasajeros() {
		return numeropasajeros;
	}

	public void setNumeropasajeros(Integer numeropasajeros) {
		this.numeropasajeros = numeropasajeros;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getTiempoestimado() {
		return tiempoestimado;
	}

	public void setTiempoestimado(String tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}

	public String getTipotransporte() {
		return tipotransporte;
	}

	public void setTipotransporte(String tipotransporte) {
		this.tipotransporte = tipotransporte;
	}
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setTransporte(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setTransporte(null);

		return servicio;
	}

}