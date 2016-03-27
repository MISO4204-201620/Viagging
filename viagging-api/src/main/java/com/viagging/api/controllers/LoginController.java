package com.viagging.api.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.UserLogin;
import com.viagging.core.constant.Profile;
import com.viagging.core.model.Usuario;
import com.viagging.core.model.mapper.UsuarioMapper;
import com.viagging.core.services.UsuarioService;
import com.viagging.rest.dto.UsuarioDTO;
import com.viagging.rest.dto.mapper.UsuarioDTOMapper;
import com.viagging.util.CookieUtil;

/**
 * The Class LoginController.
 */
@RestController
public class LoginController {
	
	/** The usuario service. */
	@Autowired
	private UsuarioService usuarioService;
	
	/** The Constant AUTHORIZATION_TOKEN_COOKIE. */
	private static final String AUTHORIZATION_TOKEN_COOKIE = "Authorization";
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private UsuarioDTOMapper usuarioDTOMapper;
	
	/**
	 * Login.
	 *
	 * @param userLogin the user login
	 * @param response the response
	 * @return the response entity
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> login(@RequestBody final UserLogin userLogin, HttpServletResponse response){
		Usuario usuario = usuarioService.findUsuarioByLoginAndPassword(userLogin.getLogin(), userLogin.getPassword());
		
		if(usuario == null){
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}
		
		UsuarioDTO usuarioDTO = UsuarioDTO.buildObject(usuario);
		addAuthorizationCookie(response, usuario);
		
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> register(@RequestBody final UsuarioDTO usuarioDTO, HttpServletResponse response){
		Usuario usuarioNuevo;
		try {
			usuarioNuevo = usuarioService.createUsuario(usuarioMapper.mapObject(usuarioDTO), Profile.USUARIO.getId());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioNuevo != null){
			addAuthorizationCookie(response, usuarioNuevo);
		}
		
		UsuarioDTO usuarioDTONuevo = usuarioDTOMapper.mapObject(usuarioNuevo);
		return new ResponseEntity<>(usuarioDTONuevo, HttpStatus.OK);
	}
	
	private void addAuthorizationCookie(HttpServletResponse response, Usuario usuario){
		String token = Jwts.builder().setSubject(usuario.getLogin())
				.claim("usuarioId", usuario.getId())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretKey")
				.compact();
		
		Cookie authCookie = CookieUtil.createCookie(AUTHORIZATION_TOKEN_COOKIE, token);
		response.addCookie(authCookie);
	}

}
