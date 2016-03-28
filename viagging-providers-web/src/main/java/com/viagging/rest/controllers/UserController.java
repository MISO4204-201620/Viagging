package com.viagging.rest.controllers;

import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.viagging.core.constant.Profile;
import com.viagging.core.services.UsuarioService;
import com.viagging.exception.LoginExistExeption;
import com.viagging.rest.dto.UsuarioDTO;

@RestController
public class UserController {
    
	public static final String USER_ERROR_MESSAGE_ADD = "Error creando el usuario";
	public static final String USER_ERROR_MESSAGE_LOGIN_EXIST = "Login ya existe, por favor cambiar de login";
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUser(@RequestBody UsuarioDTO usuarioDTO) {
		System.out.println("addUser"+usuarioDTO);
		try {
			usuarioService.createUsuario(usuarioService.buildUsuario(usuarioDTO),Profile.getValue(usuarioDTO.getPerfil().getNombre()));
		}catch (LoginExistExeption e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_LOGIN_EXIST);			
	     } 
		catch (Exception e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_ADD);
		
	     }
	}
	
	@RequestMapping(value = "/addProveedorAdministrador", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addProveedorAdministrador(@RequestBody UsuarioDTO usuarioDTO) {
		System.out.println("addUser"+usuarioDTO);
		try {
			usuarioService.createUsuario(usuarioService.buildUsuario(usuarioDTO),usuarioDTO.getPerfil().getId());
		}catch (LoginExistExeption e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_LOGIN_EXIST);			
	     } 
		catch (Exception e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_ADD);
		
	     }
	}
}
