package com.viagging.api.report.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.ReportType;
import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.factory.ReportServiceFactory;
import com.viagging.core.services.MovimientoService;
import com.viagging.api.report.rest.dto.ReporteDTO;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.ServicioService;


@RestController
public class ReportController {
		   
	   @Autowired
	   private ReportServiceFactory reportServiceFactory;
	   
	   @Autowired
	   private MovimientoService movimientoService;
	   
	   @Autowired
	   private ServicioService servicioService;
	   
	   public static final String ERROR_REPORT_NOT_FOUND = "Error reporte no válido";
		    
		@RequestMapping(value = "/createReport", method = RequestMethod.POST, produces = "application/pdf")
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<byte[]> createReport(
				@RequestBody ReporteDTO reporteDTO) {
			byte[] outputReport;
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			headers.setContentDispositionFormData("inline", "archivo.pdf");
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

			AbstractReportService reportService = reportServiceFactory.getReportService(ReportType.valueOf(reporteDTO.getTipo()));
			if (reportService != null) {
				outputReport = reportService.createReport(reporteDTO);
			} else {
				throw new NotFoundException(ERROR_REPORT_NOT_FOUND);
			}
			return new ResponseEntity<>(outputReport, headers, HttpStatus.OK);
		}
		
	    @RequestMapping(value = "/createMovimiento", method = RequestMethod.GET)
		@ResponseStatus(value = HttpStatus.OK)
		public void createMovimiento() {
	    	List<Servicio> listSe = new ArrayList<>();
	    	Servicio serv = servicioService.getServicioById(1);
	    	listSe.add(serv);
	    	serv = servicioService.getServicioById(2);
	    	listSe.add(serv);
	    	movimientoService.createMovimientos(listSe, null, null,ReportType.QUERY.toString());
		}
	    
	    
}
