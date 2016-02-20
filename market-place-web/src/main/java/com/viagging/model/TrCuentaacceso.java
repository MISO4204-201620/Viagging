package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_cuentaacceso database table.
 * 
 */
@Entity
@Table(name="tr_cuentaacceso")
@NamedQuery(name="TrCuentaacceso.findAll", query="SELECT t FROM TrCuentaacceso t")
public class TrCuentaacceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String login;

	private String password;

	//bi-directional many-to-one association to TbPerfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private TbPerfil tbPerfil;

	//bi-directional many-to-one association to TpUsuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private TpUsuario tpUsuario;

	public TrCuentaacceso() {
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

	public TbPerfil getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(TbPerfil tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

	public TpUsuario getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

}