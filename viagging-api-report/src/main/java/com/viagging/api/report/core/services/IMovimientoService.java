package com.viagging.api.report.core.services;

import java.util.List;

public interface IMovimientoService {
     
	List<Object[]> findInfoReportSearch(String query);

}