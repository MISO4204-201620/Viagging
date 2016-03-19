package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tr_paseosecologicos database table.
 * 
 */
@Entity
@Table(name="tr_paseosecologicos")
@NamedQuery(name="PaseoEcologico.findAll", query="SELECT t FROM PaseoEcologico t")
public class PaseoEcologico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String caracteristicas;

	private String ciudad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String horario;

	private byte[] imagenprincipal;

	private String restricciones;

	private String tiempoderecorrido;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="paseoEcologico")
	private List<Servicio> servicios;

	public PaseoEcologico() {
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
	
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public byte[] getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(byte[] imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getTiempoderecorrido() {
		return tiempoderecorrido;
	}

	public void setTiempoderecorrido(String tiempoderecorrido) {
		this.tiempoderecorrido = tiempoderecorrido;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setPaseoEcologico(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setPaseoEcologico(null);

		return servicio;
	}

}