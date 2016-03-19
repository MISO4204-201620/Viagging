package com.viagging.util;


	import java.util.ArrayList;
import java.util.List;

import com.viagging.rest.dto.NombreValorDTO;


	public enum CategoryEnum {

	    TRANSPORTE("01"),
	    ALOJAMIEENTO("02"),
	    PASEO_TURISTICO("03"),
	    COMIDA("04");

	    private String id;

	    private CategoryEnum(String id) {
	        this.id = id;
	    }

	    public String getId() {
	        return id;
	    }


	    public static List<NombreValorDTO> getKeysValue() {

	        List<NombreValorDTO> nombreValorDTO = new ArrayList<>();

	        for (CategoryEnum topicEnum : CategoryEnum.values()) {
	        	NombreValorDTO nombre = new NombreValorDTO();
	        	nombre.setValue(topicEnum.name());
	        	nombre.setKey(topicEnum.getId());
	            nombreValorDTO.add(nombre);
	        }

	        return nombreValorDTO;
	    }

	}

