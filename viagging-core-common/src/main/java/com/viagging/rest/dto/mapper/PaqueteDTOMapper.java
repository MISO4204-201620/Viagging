package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Paquete;
import com.viagging.rest.dto.PaqueteDTO;

@Component
public class PaqueteDTOMapper {

	@Autowired
	private ServicioDTOMapper servicioDTOMapper;
	
	public PaqueteDTO mapObject(Paquete paquete){
		PaqueteDTO paqueteDTO = new PaqueteDTO();
		paqueteDTO.setId(paquete.getId());
		paqueteDTO.setActivo(paquete.getActivo());
		paqueteDTO.setNombre(paquete.getNombrePaquete());
		paqueteDTO.setPrecio(String.valueOf(paquete.getPrecio()));
		paqueteDTO.setServicios(servicioDTOMapper.mapObjectListFromPaqueteServicio(paquete.getPaqueteServicios()));
		return paqueteDTO;
	}
    
	public List<PaqueteDTO> mapObjectList(List<Paquete> listaPaquete){
		List<PaqueteDTO> listaPaqueteDTO = new ArrayList<>();
		for (Paquete paquete : listaPaquete) {
			PaqueteDTO paqueteDTO = mapObject(paquete);
		    listaPaqueteDTO.add(paqueteDTO);
		}
		return listaPaqueteDTO;
	}
	
}
