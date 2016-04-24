package com.viagging.core.services;

import java.util.List;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;

public interface MovimientoService {
     
	List<Object[]> findInfoReportSearch(String query);
    
	void createMovimientos(List<Servicio> listServicios,List<Paquete> listPaquetes, String idUsuario,String tipo );
	
}