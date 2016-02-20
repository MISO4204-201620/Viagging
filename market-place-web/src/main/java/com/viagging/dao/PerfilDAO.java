package com.viagging.dao;

import org.springframework.stereotype.Component;

import com.viagging.model.Perfil;

@Component
public interface PerfilDAO {

	public Perfil save(String nombre);
}
