package com.orange.viagging.builder;

import java.util.List;

public interface IPropertiesVariability {
   
	void changeProperties(String path,String key);
	
	List<String> updateListProperties(List<String> lines,String key);
	
	void writeFile(String path,List<String> lines);
}
