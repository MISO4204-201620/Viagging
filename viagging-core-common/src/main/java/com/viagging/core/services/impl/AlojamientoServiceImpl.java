package com.viagging.core.services.impl;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlojamientoDAO;
import com.viagging.core.dao.ImagenServicioDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.ImagenServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.AlojamientoService;
import com.viagging.rest.dto.AlojamientoDTO;
import com.viagging.rest.dto.ImagenDTO;
import com.viagging.rest.dto.ServicioDTO;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

	@Autowired
	private AlojamientoDAO alojamientoDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	@Autowired
	private ImagenServicioDAO imagenDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Alojamiento getAlojamientoById(Integer idAlojamiento) {
		return alojamientoDAO.getAlojamientoById(idAlojamiento);
	}

	@Override
	public Alojamiento createAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.createAlojamiento(alojamiento);
	}

	@Override
	public Alojamiento updateAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.updateAlojamiento(alojamiento);
	}
	
	@Override
	public Alojamiento deleteAlojamiento(Integer idAlojamiento) {
		return alojamientoDAO.deleteAlojamiento(idAlojamiento);
	}
	
	public void createAlojamiento(AlojamientoDTO alojamientoDTO) throws JSONException {
		Alojamiento alojamiento = alojamientoDTOToModel(alojamientoDTO);
		createAlojamiento(alojamiento);
	}
	
	private Alojamiento alojamientoDTOToModel(AlojamientoDTO alojamientoDTO) throws JSONException  {
		JSONObject jsonObj = new JSONObject(alojamientoDTO.getCaracteristicas());
		Iterator<String> keys = jsonObj.keys();
		String caracteristicas = "";
		while (keys.hasNext()) {
			String key = keys.next();
			boolean isActive = jsonObj.getBoolean(key);
			if (isActive) {
				caracteristicas += key;
			}
		}
		Alojamiento alojamiento = new Alojamiento();
		alojamiento.setCiudad(alojamientoDTO.getCiudad());
		alojamiento.setRestricciones(alojamientoDTO.getRestricciones());
		alojamiento.setValorpornoche(Integer.parseInt(alojamientoDTO.getValorPorNoche()));
		alojamiento.setCaracteristicas(caracteristicas);
		Servicio servicio = servicioDTOToModel(alojamientoDTO.getServicio());
		servicioDAO.createServicio(servicio);
//		for (ImagenDTO img : alojamientoDTO.getImagenes()) {
//			System.out.println(img.getImagen() + " imagen 1");
//			ImagenServicio imagen = imagenDTOToModel(img);
//			imagenDAO.createImagenServicio(imagen);
//		}
		return alojamiento;
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
	
	private ImagenServicio imagenDTOToModel(ImagenDTO imagenDTO) {
		ImagenServicio imagen = new ImagenServicio();
//		System.out.println(imagenDTO.getImagen() + "imagen");
//		imagen.setImagen(Base64.encodeBase64URLSafeString(imagenDTO.getImagen()).getBytes());
		return imagen;
	}
}
