package com.viagging.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.viagging.core.model.Usuario;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {
	
	private Integer id;
    
	private String correo;
	
	@JsonInclude(Include.NON_NULL)
	private String numeroCelular;
	
	@JsonInclude(Include.NON_NULL)
	private String numeroDocumento;

	private String primerApellido;

	private String primerNombre;

	private String segundoApellido;

	private String segundoNombre;

	private String tipoDocumento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	/**
	 * Builds and {@link UsuarioDTO} object from an {@link Usuario} object.
	 *
	 * @param usuario the usuario
	 * @return the usuario dto
	 */
	public static UsuarioDTO buildObject(Usuario usuario){
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setId(usuario.getId());
		usuarioDto.setCorreo(usuario.getCorreo());
		usuarioDto.setNumeroCelular(usuario.getNumeroCelular());
		usuarioDto.setPrimerNombre(usuario.getPrimerNombre());
		usuarioDto.setSegundoNombre(usuario.getSegundoNombre());
		usuarioDto.setPrimerApellido(usuario.getPrimerApellido());
		usuarioDto.setSegundoApellido(usuario.getSegundoApellido());
		usuarioDto.setTipoDocumento(usuario.getTipoDocumento());
		usuarioDto.setNumeroDocumento(usuario.getNumeroDocumento());
		return usuarioDto;
	}
}
