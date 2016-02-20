package com.viagging.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tb_perfil database table.
 * 
 */
@Entity
@Table(name="tb_perfil")
@NamedQuery(name="TbPerfil.findAll", query="SELECT t FROM TbPerfil t")
public class TbPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;
    
	public TbPerfil() {
	}
	
	public TbPerfil(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	//bi-directional many-to-one association to TrCuentaacceso
	@OneToMany(mappedBy="tbPerfil")
	private List<TrCuentaacceso> trCuentaaccesos;

	//bi-directional many-to-one association to TrPermisoperfil
	@OneToMany(mappedBy="tbPerfil")
	private List<TrPermisoperfil> trPermisoperfils;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TrCuentaacceso> getTrCuentaaccesos() {
		return this.trCuentaaccesos;
	}

	public void setTrCuentaaccesos(List<TrCuentaacceso> trCuentaaccesos) {
		this.trCuentaaccesos = trCuentaaccesos;
	}

	public TrCuentaacceso addTrCuentaacceso(TrCuentaacceso trCuentaacceso) {
		getTrCuentaaccesos().add(trCuentaacceso);
		trCuentaacceso.setTbPerfil(this);

		return trCuentaacceso;
	}

	public TrCuentaacceso removeTrCuentaacceso(TrCuentaacceso trCuentaacceso) {
		getTrCuentaaccesos().remove(trCuentaacceso);
		trCuentaacceso.setTbPerfil(null);

		return trCuentaacceso;
	}

	public List<TrPermisoperfil> getTrPermisoperfils() {
		return this.trPermisoperfils;
	}

	public void setTrPermisoperfils(List<TrPermisoperfil> trPermisoperfils) {
		this.trPermisoperfils = trPermisoperfils;
	}

	public TrPermisoperfil addTrPermisoperfil(TrPermisoperfil trPermisoperfil) {
		getTrPermisoperfils().add(trPermisoperfil);
		trPermisoperfil.setTbPerfil(this);

		return trPermisoperfil;
	}

	public TrPermisoperfil removeTrPermisoperfil(TrPermisoperfil trPermisoperfil) {
		getTrPermisoperfils().remove(trPermisoperfil);
		trPermisoperfil.setTbPerfil(null);

		return trPermisoperfil;
	}

}