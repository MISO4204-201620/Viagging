package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ImagenServicioDAO;
import com.viagging.core.model.ImagenServicio;
import com.viagging.core.services.ImagenServicioService;

@Service
public class ImagenServicioServiceImpl implements ImagenServicioService{

	@Autowired
	private ImagenServicioDAO imagenServicioDAO;

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
	
}
