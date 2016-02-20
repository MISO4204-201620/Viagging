package com.viagging.dao;

import org.springframework.stereotype.Component;

import com.viagging.model.TbPerfil;

@Component
public interface TpPerfilDAO {

	public TbPerfil save(String nombre);
}
