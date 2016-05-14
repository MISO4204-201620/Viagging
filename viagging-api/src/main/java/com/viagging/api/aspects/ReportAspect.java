package com.viagging.api.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.viagging.api.constants.ProductType;
import com.viagging.api.model.Producto;
import com.viagging.core.constant.ReportType;
import com.viagging.core.services.MovimientoService;

@Aspect
public class ReportAspect {
	
	@Autowired
	private MovimientoService movimientoService;
    
    @AfterReturning(pointcut = "execution(* com.viagging.api.services.ProductsService.getProductById(..))",
    		returning= "result")
	public void afterQuery(JoinPoint joinPoint, Object result) {
		Producto produc = (Producto) result;
		List<String> products = new ArrayList<>();
		products.add(produc.getId().substring(1));
		if (produc.getTipoProducto() == ProductType.SERVICIO) {
			movimientoService.createMovimientos(products, null, null, ReportType.QUERY.toString());
		} else{
			movimientoService.createMovimientos(null, products, null, ReportType.QUERY.toString());
		}
	}
    
    @AfterReturning(pointcut = "execution(* com.viagging.api.services.ProductsService.findProducts(..))",
    		returning= "result")
	public void afterSearch(JoinPoint joinPoint, Object result) {
		@SuppressWarnings("unchecked")
		List<Producto> products =  (List<Producto>) result;
		List<String> packages =  new ArrayList<>();
		List<String> services =  new ArrayList<>();
		for (Producto producto : products) {
			if (producto.getTipoProducto() == ProductType.SERVICIO) {
				services.add(producto.getId().substring(1));
			} else{
				packages.add(producto.getId().substring(1));
			}
		}
		movimientoService.createMovimientos(services, packages, null, ReportType.SEARCH.toString());
	}

}
