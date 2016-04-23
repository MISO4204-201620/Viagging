package com.viagging.api.report.core.services.impl;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.viagging.api.report.core.services.*;
import com.viagging.api.report.rest.dto.ReporteDTO;

@Component("QueryReportService")
public class QueryReportService extends AbstractReportService {
    
	@Value("${reportes.ruta}")
	private String rutaReportes;
	
	@Value("${reportes.query}")
	private String reporteQuery;
	  
    @Autowired
	private IMovimientoService movimientoService; 
	  
	@Override
	public JasperReport getFileReport() throws JRException{
		System.out.println("ingreso getFileReport ");
		System.out.println("rutaReportes "+rutaReportes);
		System.out.println("reporteQuery "+reporteQuery);
		JasperReport	report = JasperCompileManager.compileReport(rutaReportes+reporteQuery);	
		System.out.println("ingreso getFileReport fin");
		return report;
     }
	
    @Override
	public DefaultTableModel  fillDataReport(List<Object[]> listData ) {
    	
        int i = 0;
    	String[] columnNames = {"Tipo", "Producto", "Fecha", "Usuario"};
        Object [][] data = new Object [listData.size()][4];
     
        for (Object[] objectData : listData) {
			System.out.println(objectData[0]);
			System.out.println(objectData[1]);
			System.out.println(objectData[2]);
			System.out.println(objectData[3]);
      	    data[i][0] = objectData[0];
     	    data[i][1] = objectData[1];
     	    data[i][2] = objectData[2].toString();
     	    data[i][3] = objectData[3];
        	i++;
		}
        System.out.println("da");  
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        System.out.println("daeefef");
        return tableModel;        
    }
    
    @Override
    public  List<Object[]> getInfo(ReporteDTO reporteDTO){  	
    	List<Object[]> listData =   movimientoService.findInfoReportSearch(buildQuery(reporteDTO));
    	return listData;
    }
    
    public String buildQuery(ReporteDTO datosConsulta){
    	StringBuilder queryString = new StringBuilder();
		queryString.append("select case when mov.idservicio IS NULL then 'Paquete' else 'Servicio' END as tipo, ");
		queryString.append("case when mov.idservicio IS NULL then paq.nombrepaquete else ser.nombre END as nombre, ");
		queryString.append("mov.fecha as fecha, mov.accion from tr_movimiento as mov ");
		queryString.append("INNER JOIN tp_usuario as us ");
		queryString.append("ON mov.idusuario = us.id ");
		queryString.append("LEFT JOIN tp_servicio ser ");
		queryString.append("ON mov.idservicio = ser.id ");			
		queryString.append("LEFT JOIN tp_paquete as paq ");
		queryString.append("ON mov.idpaquete = paq.id ");
		if(datosConsulta.getFechaInical() != null && !datosConsulta.getFechaInical().equals("")){
			queryString.append("where (mov.fecha BETWEEN '" +datosConsulta.getFechaInical() + "' and '" + datosConsulta.getFechaFinal() + "') and ");
		}else{
			queryString.append("where");
		}
		
		if(datosConsulta.getListaServicios() != null && !datosConsulta.getListaServicios().isEmpty()){
			queryString.append("(ser.id IN (" + buildList(datosConsulta.getListaServicios()) + ")" );
		}else{
			queryString.append("(ser.id IN (0)" );
		}
		
		if(datosConsulta.getListaPaquetes() != null && !datosConsulta.getListaPaquetes().isEmpty()){
		   queryString.append(" or  paq.id IN (" + buildList(datosConsulta.getListaPaquetes()) + "))");
		}else{
		   queryString.append(" or  paq.id IN (0) )");
		}
		queryString.append(" and mov.accion = '" + datosConsulta.getTipo() + "' ");
		
		queryString.append("ORDER BY mov.fecha ASC ");
		
		return queryString.toString();
    }
    
}
