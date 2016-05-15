package com.viagging.api.controllers;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.model.Mensaje;
import com.viagging.core.model.mapper.ConversacionMapper;
import com.viagging.core.model.mapper.MensajeMapper;
import com.viagging.core.services.ConversacionService;
import com.viagging.core.services.MensajeService;
import com.viagging.rest.dto.ConversacionDTO;
import com.viagging.rest.dto.MensajeDTO;
import com.viagging.rest.dto.mapper.ConversacionDTOMapper;
import com.viagging.rest.dto.mapper.MensajeDTOMapper;

@RestController
public class MessageController {

	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "Conversaciones no encontradas";
	
	@Autowired
	private ConversacionService conversacionService;
	
	@Autowired
	private MensajeService mensajeService;
	
	@Autowired
	private ConversacionDTOMapper conversacionDTOMapper;
	
	@Autowired
	private ConversacionMapper conversacionMapper;
	
	@Autowired
	private MensajeMapper mensajeMapper;
	
	@Autowired
	private MensajeDTOMapper mensajeDTOMapper;
	
	@RequestMapping(value = "/user/{idUsuario}/conversations", method = RequestMethod.GET)
	public List<ConversacionDTO> getConversaciones(@PathVariable Integer idUsuario){
		List<ConversacionDTO> conversacionDTO = conversacionDTOMapper.mapObjectList(conversacionService.getAllConversacionesByUsuario(idUsuario));
		if(conversacionDTO.isEmpty()){
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}
		return conversacionDTO;
	}
	
	@RequestMapping(value = "/conversations", method = RequestMethod.POST)
	public void addConversacion(@RequestBody ConversacionDTO conversacionDTO){
		conversacionService.createConversacion(conversacionMapper.mapObject(conversacionDTO));
	}
	
	@RequestMapping(value = "/conversations/{idConversacion}", method = RequestMethod.GET)
	public ConversacionDTO getConversacionById(@PathVariable Integer idConversacion){
		ConversacionDTO conversacionDTO = conversacionDTOMapper.mapObject(conversacionService.getConversacionById(idConversacion));
		return conversacionDTO;
	}
	
	@RequestMapping(value = "/conversations/{idConversacion}/message", method = RequestMethod.POST)
	public ResponseEntity<MensajeDTO> addMensajeConversacion(@RequestBody MensajeDTO mensajeDTO, @PathVariable Integer idConversacion){
		mensajeDTO.setIdConversacion(idConversacion);
		Mensaje mensaje = mensajeService.createMensajeConversacion(mensajeMapper.mapObject(mensajeDTO));
		
		if(mensaje == null){
			return new ResponseEntity<MensajeDTO>(HttpStatus.BAD_REQUEST); 
		}
		
		MensajeDTO nuevoMensaje = mensajeDTOMapper.mapObject(mensaje);
		return new ResponseEntity<MensajeDTO>(nuevoMensaje, HttpStatus.OK);
	}
	
}
