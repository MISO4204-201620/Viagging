package com.viagging.core.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tr_alimentacion database table.
=======
import javax.persistence.*;

/**
 * The persistent class for the tr_caracteristica database table.
>>>>>>> a54e8ff61442a1f89fd8355e8c1dcdc6344125c9
 * 
 */
@Entity
@Table(name="tr_caracteristica")
@NamedQueries({ @NamedQuery(name="Caracteristica.findAll", query="SELECT t FROM Caracteristica t"),
				@NamedQuery(name="Caracteristica.findByCategoria", query="SELECT t FROM Caracteristica t WHERE t.categoria = :categoria"),})
public class Caracteristica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
   
	private String categoria;
	
	private String valor;
		
	public Caracteristica() {
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}