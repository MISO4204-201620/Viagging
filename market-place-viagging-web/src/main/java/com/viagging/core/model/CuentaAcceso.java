package com.viagging.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_cuentaacceso database table.
 * 
 */
@Entity
@Table(name="tr_cuentaacceso")
@NamedQuery(name="CuentaAcceso.findAll", query="SELECT t FROM CuentaAcceso t")
public class CuentaAcceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String login;

	private String password;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CuentaAcceso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}