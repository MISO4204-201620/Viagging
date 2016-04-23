package com.viagging.api.report.controller;

import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.viagging.api.report.core.constant.ReportType;
import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.rest.dto.ReporteDTO;


@RestController
public class ReportController {
	
	   @Autowired
	   @Qualifier("SearchReportService")
	   private AbstractReportService searchReport; 
		
	   @Autowired
	   @Qualifier("QueryReportService")
	   private AbstractReportService queryReport; 
	
	   public static final String ERROR_REPORT_NOT_FOUND = "Error reporte no válido";
	
	    @RequestMapping(value = "/createReport", method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.OK)
		public String createReport(@RequestBody ReporteDTO reporteDTO) {
	    	byte[] outputReport = null;
	    	if(reporteDTO.getTipo().equals(ReportType.QUERY.toString())){
	        	 outputReport = queryReport.createReport(reporteDTO);
		    }else if(reporteDTO.getTipo().equals(ReportType.SALE.toString())){

		    }else if(reporteDTO.getTipo().equals(ReportType.SEARCH.toString())){
		    	 outputReport = searchReport.createReport(reporteDTO);
		    }else {
		    	throw new NotFoundException(ERROR_REPORT_NOT_FOUND);
		    }
	        
	        return outputReport.toString();
		}
	    
}
