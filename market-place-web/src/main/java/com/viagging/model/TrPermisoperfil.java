package com.viagging.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tr_permisoperfil database table.
 * 
 */
@Entity
@Table(name="tr_permisoperfil")
@NamedQuery(name="TrPermisoperfil.findAll", query="SELECT t FROM TrPermisoperfil t")
public class TrPermisoperfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to TbPerfil
	@ManyToOne
	@JoinColumn(name="idperfil")
	private TbPerfil tbPerfil;

	//bi-directional many-to-one association to TpModulo
	@ManyToOne
	@JoinColumn(name="idmodulo")
	private TpModulo tpModulo;

	public TrPermisoperfil() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbPerfil getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(TbPerfil tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

	public TpModulo getTpModulo() {
		return this.tpModulo;
	}

	public void setTpModulo(TpModulo tpModulo) {
		this.tpModulo = tpModulo;
	}

}