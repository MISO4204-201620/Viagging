package com.viagging.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viagging.core.dao.*;
import com.viagging.core.model.Modulo;

@Controller
public class ORMContoller {



//	@RequestMapping(value = "/ormFindAllUsers", method=RequestMethod.GET)
//    public ModelAndView ormFindAllUsers() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");
//		System.out.println("prueba 1111rr34");
//		ModuloDAO tpmoduloDAO = applicationContext.getBean(ModuloDAO.class);
//		List<Modulo> listModulos = tpmoduloDAO.getAll();
//		return new ModelAndView("/orm/orm", "users", "");
//    }
//
//	@RequestMapping(value = "/ormUpdateUser/iduser/{iduser}/enabled/{enabled}", method=RequestMethod.GET)
//	public ModelAndView ormUpdateUser(
//    		@PathVariable(value="iduser") int iduser,
//    		@PathVariable(value="enabled") boolean enabled) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "/application-context.xml");
//		System.out.println("ORMContoller ormUpdateUser is called");
//		ModuloDAO tpmoduloDAO = applicationContext.getBean(ModuloDAO.class);
//		tpmoduloDAO.save("prueba");
//        return new ModelAndView("/orm/orm", "result", "");
//
//    }

}
