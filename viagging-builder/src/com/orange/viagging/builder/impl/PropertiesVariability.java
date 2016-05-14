package com.orange.viagging.builder.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.orange.viagging.builder.IFeatureReader;
import com.orange.viagging.builder.IPropertiesVariability;

public class PropertiesVariability implements IPropertiesVariability {
    
	public static final  String SEPARATOR = "=";
	public static final  String TRUE = "true";
	
	@Override 
	public void changeProperties(String path, String key) {
	    IFeatureReader reader = new FeatureTxtReader();   
	    List<String> lines = reader.readFeatures(path);
	    writeFile(path, updateListProperties(lines,key));
	}
	
	@Override
	public List<String> updateListProperties(List<String> lines, String key) {
		List<String> newList = new ArrayList<>();
		
		for (String line : lines) {
			 if (line.substring(0, line.indexOf(SEPARATOR)).equals(key)) {
				 newList.add(line.substring(0, line.indexOf(SEPARATOR)+1)+TRUE);
			 } else {
				 newList.add(line);
			 } 
		}
		
		return newList;
		
	}
	
	@Override
	public void writeFile(String path, List<String> lines) {
		Path file = Paths.get(path);
		
		try (BufferedWriter writer = Files.newBufferedWriter(
		        file, Charset.defaultCharset())) {
		  
		  for (String line : lines) {
				writer.append(line);
				writer.newLine();
		  }
		  writer.flush();
		} catch(IOException exception) {
		  System.out.println("Error writing to file");
		}
	}
}
