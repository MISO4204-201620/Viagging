package com.viagging.rest.dto;

import java.util.Date;


public class ConversacionDTO {
	
	private Integer id;


	private Date fechaUltimoMensaje;


	private UsuarioDTO usuario1;


	private UsuarioDTO usuario2;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFechaUltimoMensaje() {
		return fechaUltimoMensaje;
	}


	public void setFechaUltimoMensaje(Date fechaUltimoMensaje) {
		this.fechaUltimoMensaje = fechaUltimoMensaje;
	}


	public UsuarioDTO getUsuario1() {
		return usuario1;
	}


	public void setUsuario1(UsuarioDTO usuario1) {
		this.usuario1 = usuario1;
	}


	public UsuarioDTO getUsuario2() {
		return usuario2;
	}


	public void setUsuario2(UsuarioDTO usuario2) {
		this.usuario2 = usuario2;
	}
}
