package com.viagging.core.constant;

public enum Profile {

	USUARIO("1", "Usuario"), 
	PROVEEDOR("2", "Proveedor"), 
	ADMINISTRADOR("3", "Administrador");

	private String id;
	
	private String name;

	private Profile(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String getName(){
		return name;
	}
    
	public static String getValue(String name) {
		String value = "";
		for (Profile profile : Profile.values()) {
			if(profile.getName().equalsIgnoreCase(name)){
				value = profile.getId();				
			    break;
			}
		}
		return value;
	}
}
