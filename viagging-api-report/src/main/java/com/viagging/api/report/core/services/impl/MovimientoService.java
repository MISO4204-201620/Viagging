package com.viagging.api.report.core.services.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.api.report.core.dao.MovimientoDAO;
import com.viagging.api.report.core.model.mapper.MovimientoMapper;
import com.viagging.api.report.core.services.IMovimientoService;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.UsuarioService;

@Service
public class MovimientoService implements  IMovimientoService  {
	
	@Autowired
	private MovimientoMapper<Serializable> movimientoMapper;
	
	@Autowired
	private MovimientoDAO movimientoDAO;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private ExecutorService executorService;
		
	@PostConstruct
    public void init() {
        executorService = Executors.newCachedThreadPool();
    }
	
	@Override
	public List<Object[]> findInfoReportSearch(String query){
		List<Object[]> list = movimientoDAO.findInfoReportSearch(query);
		return list;
	}
	
	@Override
	public void createMovimientos(final List<Servicio> listServicios,final List<Paquete> listPaquetes,final String idUsuario,final String tipo ){
	        executorService.submit(new Callable<Object>() {
                public Object call() throws Exception {
                	ejecutarProceso(listServicios, listPaquetes, idUsuario, tipo);
                    return null;
                }
	        });			
	}
    	
	private void ejecutarProceso(final List<Servicio> listServicios,final List<Paquete> listPaquetes,final String idUsuario,final String tipo){
		Usuario usuario = usuarioService.getUsuarioById(Integer.valueOf(idUsuario));
		if(listPaquetes  != null){
			for (Paquete paquete : listPaquetes) {
				movimientoDAO.createMovimiento(movimientoMapper.mapObject(paquete, usuario, tipo));
			}
		}
		if(listServicios != null){
			for (Servicio servicio : listServicios) {
				movimientoDAO.createMovimiento(movimientoMapper.mapObject(servicio, usuario, tipo));
			}
		}
	}
	
}