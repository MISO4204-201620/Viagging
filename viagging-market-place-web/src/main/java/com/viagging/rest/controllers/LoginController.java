package com.viagging.rest.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.Profile;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Usuario;
import com.viagging.core.model.mapper.UsuarioMapper;
import com.viagging.core.services.CuentaAccesoService;
import com.viagging.core.services.UsuarioService;
import com.viagging.rest.dto.UsuarioDTO;
import com.viagging.rest.dto.mapper.UsuarioDTOMapper;
import com.viagging.rest.model.UserLogin;
import com.viagging.util.CookieUtil;

/**
 * The Class LoginController.
 */
@RestController
@RequestMapping("/user")
public class LoginController {

	/** The Constant SECRET_KEY. */
	private static final String SECRET_KEY = "secretKey";
	
	/** The Constant AUTHORIZATION_TOKEN_COOKIE. */
	private static final String AUTHORIZATION_TOKEN_COOKIE = "Authorization";
	
	/** The usuario service. */
	@Autowired
	protected UsuarioService usuarioService;

	@Autowired
	protected CuentaAccesoService cuentaAccesoService;

	/** The usuario mapper. */
	@Autowired
	protected UsuarioMapper usuarioMapper;

	/** The usuario dto mapper. */
	@Autowired
	protected UsuarioDTOMapper usuarioDTOMapper;
	
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

		CuentaAcceso cuentaAcceso = cuentaAccesoService.findCuentaAccesoByUsuarioAndProfile(usuario.getId(), Profile.USUARIO.getId());
		if(cuentaAcceso == null){
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}

		UsuarioDTO usuarioDTO = UsuarioDTO.buildObject(usuario);
		addAuthorizationCookie(response, usuario);

		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}

	/**
	 * Register.
	 *
	 * @param usuarioDTO the usuario dto
	 * @param response the response
	 * @return the response entity
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> register(@RequestBody final UsuarioDTO usuarioDTO, HttpServletResponse response){
		
		Usuario usuario = usuarioService.getUsuarioByEmail(usuarioDTO.getCorreo());
		if(usuario == null){
			//Usuario nuevo
			try {
				usuario = usuarioService.createUsuario(usuarioMapper.mapObject(usuarioDTO), Profile.USUARIO.getId());
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			if(StringUtils.isEmpty(usuario.getPassword()) && StringUtils.isEmpty(usuario.getLogin()) &&
				!StringUtils.isEmpty(usuarioDTO.getPassword()) && !StringUtils.isEmpty(usuarioDTO.getLogin())){
				//Usuario registrado por red social
				usuario.setLogin(usuarioDTO.getLogin());
				usuario.setPassword(usuarioDTO.getPassword());
				usuarioService.updateUsuario(usuarioMapper.mapObject(usuarioDTO));
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
			
		addAuthorizationCookie(response, usuario);
		UsuarioDTO usuarioDTONuevo = usuarioDTOMapper.mapObject(usuario);
		
		return new ResponseEntity<>(usuarioDTONuevo, HttpStatus.OK);
	}
	
	/**
	 * Gets the usuario by email.
	 *
	 * @param email the email
	 * @param response the response
	 * @return the usuario by email
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> getUsuarioByEmail(@QueryParam("email") String email, HttpServletResponse response){
		Usuario usuario = usuarioService.getUsuarioByEmail(email);
		
		if(usuario == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CuentaAcceso cuentaAcceso = cuentaAccesoService.findCuentaAccesoByUsuarioAndProfile(usuario.getId(), Profile.USUARIO.getId());
		if(cuentaAcceso == null){
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}

		UsuarioDTO usuarioDTO = UsuarioDTO.buildObject(usuario);
		addAuthorizationCookie(response, usuario);

		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}

	/**
	 * Adds the authorization cookie.
	 *
	 * @param response the response
	 * @param usuario the usuario
	 */
	protected void addAuthorizationCookie(HttpServletResponse response, Usuario usuario){
		String token = Jwts.builder().setSubject(usuario.getLogin())
				.claim("usuarioId", usuario.getId())
				.claim("app", "marketplace")
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();

		Cookie authCookie = CookieUtil.createCookie(AUTHORIZATION_TOKEN_COOKIE, token);
		response.addCookie(authCookie);
	}
}
