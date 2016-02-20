package com.viagging;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viagging.dao.TpModuloDAO;
import com.viagging.dao.TpPerfilDAO;
import com.viagging.model.TpModulo;


@Controller
public class TestController {
	 	
	@RequestMapping("/test")
	public String test(){
		return "view";
	}
	
	@RequestMapping("/saveModulo")
	public String saveModulo(){ 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");
		TpModuloDAO tpmoduloDAO = applicationContext.getBean(TpModuloDAO.class);
		tpmoduloDAO.save("prueba");
		return "view";
	}
	
	@RequestMapping("/savePerfil")
	public String savePerfil(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");	
		TpPerfilDAO perfilDAO = applicationContext.getBean(TpPerfilDAO.class);
		perfilDAO.save("administrador");
		return "view";
	}
	
	@RequestMapping(value = "/getAllModulos", method=RequestMethod.GET)
	public ModelAndView getAllModulos(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");
		System.out.println("prueba 1111rr34");		
		TpModuloDAO tpmoduloDAO = applicationContext.getBean(TpModuloDAO.class);		
		List<TpModulo> listModulos = tpmoduloDAO.getAll();
		return new ModelAndView("/view", "result", listModulos);
	}
	
	@RequestMapping("/getModuloById")
	public String getModuloById(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");		
		TpModuloDAO tpmoduloDAO = applicationContext.getBean(TpModuloDAO.class);		
		tpmoduloDAO.getById(2);;
		return "view";
	}
	
	
}
