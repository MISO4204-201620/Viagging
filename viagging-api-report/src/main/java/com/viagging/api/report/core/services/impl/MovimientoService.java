package com.viagging.api.report.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.api.report.core.dao.MovimientoDAO;
import com.viagging.api.report.core.services.IMovimientoService;

@Service
public class MovimientoService implements  IMovimientoService  {
	
	@Autowired
	private MovimientoDAO movimientoDAO;
		
	@Override
	public List<Object[]> findInfoReportSearch(String query){
		List<Object[]> list = movimientoDAO.findInfoReportSearch(query);
		return list;
	}

}