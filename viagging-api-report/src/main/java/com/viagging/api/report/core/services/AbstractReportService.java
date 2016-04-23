package com.viagging.api.report.core.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.viagging.api.report.core.dao.impl.MovimientoDAOImpl;
import com.viagging.api.report.rest.dto.ReporteDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public abstract class AbstractReportService {
   	
	abstract public JasperReport getFileReport() throws JRException;
    
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReportService.class);
	
    private JasperPrint fillReport(Map<String, Object> map,JasperReport report,DefaultTableModel tableModel ) throws JRException{
	     JasperPrint print = JasperFillManager.fillReport(report, map, new JRTableModelDataSource(tableModel));
         return print;
     }

    public void createReport( ReporteDTO reporteDTO ){		
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			List<Object[]> listDatos = getInfo(reporteDTO);
	        DefaultTableModel dataReport = fillDataReport(listDatos);
	        JasperReport report = getFileReport();
		    JasperPrint print = fillReport(map, report,dataReport);
		    byte[] output = JasperExportManager.exportReportToPdf(print);
		    System.out.println(output.toString()+"df");
		    JasperExportManager.exportReportToPdfFile(print, "D:\\ANDES\\Fabricas_Software\\reportes\\InformePaisesMySQ1L.pdf");
		    JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			LOGGER.error(e.getMessage());	
		} catch (Exception e) {
			LOGGER.error(e.getMessage());	
		}	
	}
    
    abstract public DefaultTableModel  fillDataReport(List<Object[]> listData);

    abstract public List<Object[]> getInfo(ReporteDTO reporteDTO); 
    
    public static String buildList(List<?> listItems){
    	StringBuilder concatenadoServicios = new StringBuilder();  
    	   for (int i = 0; i < listItems.size(); i++) {
    		   if(listItems.get(i) instanceof ServicioDTO){
    		      concatenadoServicios.append(((ServicioDTO)listItems.get(i)).getId());
    		   }else if (listItems.get(i) instanceof PaqueteDTO){
    			   concatenadoServicios.append(((PaqueteDTO)listItems.get(i)).getId());
    		   }
    		     
    		   if( i != listItems.size()-1){
    			   concatenadoServicios.append(",");   
    		   }
		   }	
    	return concatenadoServicios.toString();
    }
}
