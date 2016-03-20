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
import com.viagging.api.services.impl.LoginService;
import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.UsuarioDTO;
import com.viagging.util.CookieUtil;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	private static final String AUTHORIZATION_TOKEN_COOKIE = "viagging_authorization_token";
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> login(@RequestBody final UserLogin userLogin, HttpServletResponse response){
		Usuario usuario = loginService.getUserDetails(userLogin.getLogin(), userLogin.getPassword());
		
		if(usuario == null){
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}
		
		UsuarioDTO usuarioDTO = UsuarioDTO.buildObject(usuario);
		
		String token = Jwts.builder().setSubject(usuario.getLogin())
				.claim("usuarioId", usuario.getId())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretKey")
				.compact();
		
		Cookie authCookie = CookieUtil.createCookie(AUTHORIZATION_TOKEN_COOKIE, token);
		response.addCookie(authCookie);
		
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}

}
