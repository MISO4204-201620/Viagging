package com.viagging.core.services.impl;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.AlimentacionService;
import com.viagging.rest.dto.AlimentacionDTO;
import com.viagging.rest.dto.ServicioDTO;


@Service
public class AlimentacionServiceImpl implements  AlimentacionService  {

	
	@Autowired
	private AlimentacionDAO alimentacionDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Alimentacion getAlimentacionById(Integer idAlimentacion) {
		return alimentacionDAO.getAlimentacionById(idAlimentacion);
	}

	@Override
	public Alimentacion createAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.createAlimentacion(alimentacion);
	}

	@Override
	public Alimentacion updateAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.updateAlimentacion(alimentacion);
	}
	
	@Override
	public Alimentacion deleteAlimentacion(Integer idAlimentacion) {
		return alimentacionDAO.deleteAlimentacion(idAlimentacion);
	}

	@Override
	public void createAlimentacion(AlimentacionDTO alojamiento) throws JSONException {
		// TODO Auto-generated method stub
		
	}
	
	private Alimentacion alimentacionDTOToModel(AlimentacionDTO alimentacionDTO) throws JSONException {
		JSONObject jsonObj = new JSONObject(alimentacionDTO.getCaracteristicas());
		Iterator<String> keys = jsonObj.keys();
		String caracteristicas = "";
		while (keys.hasNext()) {
			String key = keys.next();
			boolean isActive = jsonObj.getBoolean(key);
			if (isActive) {
				caracteristicas += key;
			}
		}
		Alimentacion alimentacion = new Alimentacion();
		alimentacion.setCiudad(alimentacionDTO.getCiudad());
		alimentacion.setHorarioapertura(alimentacionDTO.getHorarioApertura());
		alimentacion.setHorariocierre(alimentacionDTO.getHorarioCierre());
		alimentacion.setPreciomayor(Integer.parseInt(alimentacionDTO.getPrecioMayor()));
		alimentacion.setPreciomenor(Integer.parseInt(alimentacionDTO.getPrecioMenor()));
		alimentacion.setRestricciones(alimentacionDTO.getRestricciones());
		alimentacion.setCaracteristicas(caracteristicas);
		Servicio servicio = servicioDTOToModel(alimentacionDTO.getServicio());
		servicioDAO.createServicio(servicio);
		return alimentacion;
	}
	
	private Servicio servicioDTOToModel(ServicioDTO servicioDTO) {
		Servicio servicio = new Servicio();
		servicio.setActivo(true);
		Usuario usuario = usuarioDAO.getUsuarioById(1);
		servicio.setUsuario(usuario);
		servicio.setDescripcion(servicioDTO.getDescripcionCorta());
		servicio.setNombre(servicioDTO.getNombre());
		return servicio;
		
	}
}
