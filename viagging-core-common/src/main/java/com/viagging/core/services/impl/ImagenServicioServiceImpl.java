package com.viagging.core.services.impl;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ImagenServicioDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.ImagenServicio;
import com.viagging.core.services.ImagenServicioService;

@Service
public class ImagenServicioServiceImpl implements ImagenServicioService{

	@Autowired
	private ImagenServicioDAO imagenServicioDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;

	@Override
	public ImagenServicio getImagenServicioById(Integer idImagenServicio) {
		return imagenServicioDAO.getImagenServicioById(idImagenServicio);
	}

	@Override
	public ImagenServicio createImagenServicio(ImagenServicio imagenServicio) {
		return imagenServicioDAO.createImagenServicio(imagenServicio);
	}

	
	@Override
	public ImagenServicio deleteImagenServicio(Integer idImagenServicio) {
		return imagenServicioDAO.deleteImagenServicio(idImagenServicio);

	}

	@Override
	public void createImagenServicio(String imagenServicio, String idServicio) {
		String encoded = Base64.encodeBase64URLSafeString(imagenServicio.getBytes());
		ImagenServicio imagen = new ImagenServicio();
		imagen.setImagen(encoded.getBytes());
		imagen.setServicio(servicioDAO.getServicioById(Integer.parseInt(idServicio)));
		createImagenServicio(imagen);
	}
	
}
