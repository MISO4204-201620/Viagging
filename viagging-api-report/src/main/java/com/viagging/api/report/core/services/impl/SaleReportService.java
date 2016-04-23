package com.viagging.api.report.core.services.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.core.services.IMovimientoService;
import com.viagging.api.report.rest.dto.ReporteDTO;


public class SaleReportService extends AbstractReportService {
    
	@Autowired
	private IMovimientoService movimientoService; 
	
	@Override
	public JasperReport getFileReport() throws JRException{
		JasperReport	report = JasperCompileManager.compileReport("D:\\ANDES\\Fabricas_Software\\reportes\\reporte1.jrxml");	
	    return report;
     }
	
    @Override
	public DefaultTableModel  fillDataReport(List<Object[]> listData) {
		DefaultTableModel tableModel;
		String[] columnNames = {"Id", "Name", "Department", "Email"};
        String[][] data = {
            {"Sale", "Hotel Decameron", "2014-02-12", "Jose Rivera"},
            {"Paquete", "Hotel Decameron1", "2014-02-12", "Jose Rivera"},
            {"Paquete1", "R Linz11", "Paedriatics", "rlinz@heremail.com"},
            {"444", "V Sethi", "Nephrology", "vsethi@whomail.com"},
            {"555", "K Rao", "Orthopaedics", "krao@whatmail.com"},
            {"666", "V Santana", "Nephrology", "vsan@whenmail.com"},
            {"777", "J Pollock", "Nephrology", "jpol@domail.com"},
            {"888", "H David", "Nephrology", "hdavid@donemail.com"},
            {"999", "P Patel", "Nephrology", "ppatel@gomail.com"},
            {"101", "C Comer", "Nephrology", "ccomer@whymail.com"}
        };
        tableModel = new DefaultTableModel(data, columnNames);
        return tableModel;
        
    }
    
    public  List<Object[]> getInfo(ReporteDTO reporteDTO){
    	movimientoService.findInfoReportSearch("");
		return null;
    }
}
