package com.viagging.rest.model;

import java.util.List;

import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.util.Range;

public class MarketPlaceConfig {

	private List<NombreValorDTO> categories;
	
	private List<Range> prices;

	public List<NombreValorDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<NombreValorDTO> categories) {
		this.categories = categories;
	}

	public List<Range> getPrices() {
		return prices;
	}

	public void setPrices(List<Range> precios) {
		this.prices = precios;
	}	
		
}
