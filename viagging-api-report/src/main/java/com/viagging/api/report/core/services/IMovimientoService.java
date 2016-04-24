package com.viagging.api.report.core.services;

import java.util.List;
import java.util.concurrent.Future;

import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;

public interface IMovimientoService {
     
	List<Object[]> findInfoReportSearch(String query);
    
	void createMovimientos(List<Servicio> listServicios,List<Paquete> listPaquetes, String idUsuario,String tipo );
	
}