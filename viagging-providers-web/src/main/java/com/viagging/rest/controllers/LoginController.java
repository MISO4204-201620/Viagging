package com.viagging.rest.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.Profile;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.CuentaAccesoService;
import com.viagging.core.services.UsuarioService;
import com.viagging.core.services.VariabilidadService;
import com.viagging.rest.dto.UserLoginDTO;
import com.viagging.rest.dto.UsuarioDTO;
import com.viagging.rest.dto.VariabilidadDTO;
import com.viagging.util.CookieUtil;

/**
 * The Class LoginController.
 */
@RestController
public class LoginController {

	/** The usuario service. */
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private CuentaAccesoService cuentaAccesoService;
	
	@Autowired
	private VariabilidadService variabilidadService;
	
	/** The Constant AUTHORIZATION_TOKEN_COOKIE. */
	private static final String AUTHORIZATION_TOKEN_COOKIE = "Authorization";

	/**
	 * Login.
	 *
	 * @param userLogin the user login
	 * @param response the response
	 * @return the response entity
	 */
	@RequestMapping(value = "/loginProvAdmin", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody final UserLoginDTO userLogin, HttpServletResponse response){
		Usuario usuario = usuarioService.findUsuarioByLoginAndPassword(userLogin.getLogin(), userLogin.getPassword());
		VariabilidadDTO variabilidad = variabilidadService.getVariabilidad();
		if(usuario == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		CuentaAcceso cuentaAcceso = cuentaAccesoService.findCuentaAccesoByUsuarioAndProfile(usuario.getId(), Profile.getValue(userLogin.getProfile()));
		if(cuentaAcceso == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UsuarioDTO usuarioDTO = UsuarioDTO.buildObject(usuario);
		addAuthorizationCookie(response, usuario);
        Map<String, Object> map = new HashMap<>();
        map.put("usuario", usuarioDTO);
        map.put("derivadorReportes", variabilidad.isHasReport());
        map.put("derivadorMensajes", variabilidad.isHasMessage());
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}



	/**
	 * Adds the authorization cookie.
	 *
	 * @param response the response
	 * @param usuario the usuario
	 */
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
