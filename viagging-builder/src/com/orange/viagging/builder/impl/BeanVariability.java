package com.orange.viagging.builder.impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.orange.viagging.builder.utils.Utils;

public class BeanVariability {

	public void modifyMvcConfig(String fileName, String path, String beanId, String beanClass, boolean active) {

		String file = Utils.getAttributeConfiguration(fileName, path);
		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList beansList = doc.getElementsByTagName("beans");
			Node beans = beansList.item(0);
			
			boolean beanExists = false;
			Node beanNode = null;
			for (int i = 0; i < beans.getChildNodes().getLength(); i++) {
				Node bean = beans.getChildNodes().item(i);
				
				if(bean.getAttributes() != null && bean.getNodeName().equals("bean")){
					
					for(int j = 0; j < bean.getAttributes().getLength(); j++){
						Node attribute = bean.getAttributes().item(j);
						
						if(attribute.getNodeName().equals("id")
							&& attribute.getNodeValue().equals(beanId)){
							beanExists = true;
							beanNode = bean;
							break;
						}
						
						if(beanNode != null){
							break;
						}
					}
					if(beanNode != null){
						break;
					}
				}
			}
			
			if(beanExists && !active){
				System.out.println("Removiendo bean " + beanId);
				beans.removeChild(beanNode);
			} else if(!beanExists && active) {
				System.out.println("Agregando bean " + beanId);
				Element beanElement = doc.createElement("bean");
				beanElement.setAttribute("id", beanId);
				beanElement.setAttribute("class", beanClass);
				beans.appendChild(beanElement);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
