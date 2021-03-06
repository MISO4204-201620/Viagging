package com.viagging.rest.controllers;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.Profile;
import com.viagging.core.model.CuentaAcceso;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.CuentaAccesoService;
import com.viagging.core.services.UsuarioService;
import com.viagging.exception.LoginExistExeption;
import com.viagging.rest.dto.UsuarioDTO;

@RestController
public class UserController {
    
	public static final String USER_ERROR_MESSAGE_ADD = "Error creando el usuario";
	public static final String USER_ERROR_MESSAGE_UPDATE = "Error actualizando el usuario";
	public static final String USER_ERROR_MESSAGE_LOGIN_EXIST = "Login ya existe, por favor cambiar de login";
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private CuentaAccesoService cuentaAccesoService; 
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUser(@RequestBody UsuarioDTO usuarioDTO) {
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
		try {
			usuarioService.createUsuario(usuarioService.buildUsuario(usuarioDTO),usuarioDTO.getPerfil().getId());
		}catch (LoginExistExeption e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_LOGIN_EXIST);			
	     } 
		catch (Exception e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_ADD);
		
	     }
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<UsuarioDTO> getUsers() {
		List<CuentaAcceso> cuentasAcceso = cuentaAccesoService.getAllCuentaAcceso();
		return UsuarioDTO.buildListObject(cuentasAcceso); 
	}
	
	@RequestMapping(value = "/updateProvider", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateProvider(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.buildUsuario(usuarioDTO);
		usuario.setId(Integer.parseInt(usuarioDTO.getId()));
		usuarioService.updateUsuario(usuario);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateUser(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			usuarioService.updateUsuario(usuarioService.buildUsuario(usuarioDTO));
		}catch (Exception e) {
			throw new NotFoundException(USER_ERROR_MESSAGE_UPDATE);		
	     }
	}
	
   @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
   @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@RequestBody String idUser) {	
    	usuarioService.deleteUser(Integer.valueOf(idUser));
    }
   

    @RequestMapping(value = "/getUserByDocument", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public UsuarioDTO getUser(@QueryParam("numeroDocumento") String numeroDocumento) {
		Usuario usuario = usuarioService.findUsuarioByNumber(numeroDocumento);
		return UsuarioDTO.buildObject(usuario);
    }
    
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public UsuarioDTO getUser(@QueryParam("userId") Integer userId) {
		Usuario usuario = usuarioService.getUsuarioById(userId);
		return UsuarioDTO.buildObject(usuario);
	}
}
