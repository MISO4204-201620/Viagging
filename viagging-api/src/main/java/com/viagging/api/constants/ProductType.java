package com.viagging.api.constants;

public enum ProductType {

	SERVICIO("S"),
	
	PAQUETE("P");
	
	private String prefix;
	
	public String getPrefix(){
		return this.prefix;
	}
	
	ProductType(String prefix){
		this.prefix = prefix;
	}
}
