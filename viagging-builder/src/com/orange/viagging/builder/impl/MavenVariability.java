package com.orange.viagging.builder.impl;

import java.io.File;
import java.util.ResourceBundle;

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

/**
 * Implementación de la variabilidad con maven
 * @author karenvega
 *
 */
public class MavenVariability {
	
	/**
	 * Modifica el pom para agregar la dependencia de reportes
	 * @param fileName nombre del archivo de configuración del proyecto
	 * @param path ruta de la carpeta raiz de los proyectos viagging
	 */
	public void modifyPom(String fileName, String path) {
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		String file = rb.getString(path);
		System.out.println(rb.getString(path) + "Ruta");
		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("modules");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				Element reporte = doc.createElement("module");
				reporte.appendChild(doc.createTextNode("viagging-api-report"));
				nNode.appendChild(reporte);
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
