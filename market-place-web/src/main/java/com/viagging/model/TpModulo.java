package com.viagging.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tp_modulo")

@NamedQueries( { @NamedQuery(name="TpModulo.findAll", query="SELECT t FROM TpModulo t"),
		         @NamedQuery(name="TpModulo.findById", query="SELECT t FROM TpModulo t where t.id = :id")})
public class TpModulo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to TrPermisoperfil
	@OneToMany(mappedBy="tpModulo")
	private List<TrPermisoperfil> trPermisoperfils;

	public TpModulo() {
	}

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

	public List<TrPermisoperfil> getTrPermisoperfils() {
		return this.trPermisoperfils;
	}

	public void setTrPermisoperfils(List<TrPermisoperfil> trPermisoperfils) {
		this.trPermisoperfils = trPermisoperfils;
	}

	public TrPermisoperfil addTrPermisoperfil(TrPermisoperfil trPermisoperfil) {
		getTrPermisoperfils().add(trPermisoperfil);
		trPermisoperfil.setTpModulo(this);

		return trPermisoperfil;
	}

	public TrPermisoperfil removeTrPermisoperfil(TrPermisoperfil trPermisoperfil) {
		getTrPermisoperfils().remove(trPermisoperfil);
		trPermisoperfil.setTpModulo(null);

		return trPermisoperfil;
	}

}