package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Modulo;
import com.viagging.core.services.ModuloService;
import com.viagging.rest.dto.PostJSON;
import com.viagging.rest.dto.UsuarioDTO;

//import com.viagging.rest.dto.PostJSON;

@RestController //will add automatically the @ResponseBody annotation to all methods
public class RestTemplateControllerExample {
	
	public static final String USUARIO_ERROR_MESSAGE_NOT_FOUND = "usuario no encontrado";
	
	/** The modulo service. */
	@Autowired
	private ModuloService moduloService;
	
	  //JSON SAVES a post
	  @RequestMapping(value = "/savePost", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public UsuarioDTO savePost(@RequestBody PostJSON postJSON) {
          
		  
		  UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		  System.out.println("savePost postJSON.getUserId(): " + postJSON.getUserId());
		  System.out.println("savePost postJSON.getTitle(): " + postJSON.getTitle());
		  System.out.println("savePost postJSON.getId(): " + postJSON.getId());
		  System.out.println("savePost postJSON.getBody(): " + postJSON.getBody());
		  System.out.println("@RestTemplateControllerExample savePost is called");
		  System.out.println("joseee");
		  Modulo modulo = new Modulo();
	      modulo.setNombre("ccc");
		  moduloService.createModulo(modulo);		  
		  
		  usuarioDTO.setCorreo("jose@gmail.com");
		  /*if(usuarioDTO == null){
      	      throw new NotFoundException(USUARIO_ERROR_MESSAGE_NOT_FOUND);
          }*/
		  
		  return usuarioDTO;
	  }
	  
	  //JSON SAVES a post
	  @RequestMapping(value = "/getServices", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<UsuarioDTO> getServices(@RequestBody PostJSON postJSON) {
          
		  List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
		  UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		  System.out.println("savePost postJSON.getUserId(): " + postJSON.getUserId());
		  System.out.println("savePost postJSON.getTitle(): " + postJSON.getTitle());
		  System.out.println("savePost postJSON.getId(): " + postJSON.getId());
		  System.out.println("savePost postJSON.getBody(): " + postJSON.getBody());
		  System.out.println("@RestTemplateControllerExample savePost is called");
		  System.out.println("joseee");
		  //Modulo modulo = new Modulo();
	      //modulo.setNombre("ccc");
		  //moduloService.createModulo(modulo);		  
		  
		  usuarioDTO.setCorreo("jose@gmail.com");
		  usuarioDTO.setNumeroDocumento(1030583889);
		  listUsuarioDTO.add(usuarioDTO);
		  /*if(usuarioDTO == null){
      	      throw new NotFoundException(USUARIO_ERROR_MESSAGE_NOT_FOUND);
          }*/ 
		  usuarioDTO = new UsuarioDTO(); 
		  usuarioDTO.setNumeroDocumento(1030583888);
		  listUsuarioDTO.add(usuarioDTO);
		  usuarioDTO = new UsuarioDTO(); 
		  usuarioDTO.setNumeroDocumento(1030583887);
		  listUsuarioDTO.add(usuarioDTO);
		  usuarioDTO = new UsuarioDTO(); 
		  usuarioDTO.setNumeroDocumento(1030583886);
		  listUsuarioDTO.add(usuarioDTO);
		  usuarioDTO = new UsuarioDTO(); 
		  usuarioDTO.setNumeroDocumento(1030583885);
		  listUsuarioDTO.add(usuarioDTO);
		  return listUsuarioDTO;
	  }
	  
}
