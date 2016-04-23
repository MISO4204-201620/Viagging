package com.viagging.api.report.core.dao;

import java.util.List;

import com.viagging.core.model.Movimiento;

public interface MovimientoDAO {
	
	List<Object[]> findInfoReportSearch(String query);

}

