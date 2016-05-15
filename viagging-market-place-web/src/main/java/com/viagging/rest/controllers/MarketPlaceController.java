package com.viagging.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.PriceRange;
import com.viagging.rest.dto.NombreValorDTO;
import com.viagging.rest.model.Components;
import com.viagging.rest.model.MarketPlaceConfig;
import com.viagging.util.CategoryEnum;

@RestController
public class MarketPlaceController {

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public MarketPlaceConfig getMarketPlaceConfig(){
		return initMarketPlaceConfig();
	}

	private MarketPlaceConfig initMarketPlaceConfig(){
		MarketPlaceConfig marketPlaceConfig = new MarketPlaceConfig();
		marketPlaceConfig.setCategories(buildCategories());
		marketPlaceConfig.setPrices(PriceRange.getKeyValues());
		marketPlaceConfig.setComponents(getEnabledComponents());
		return marketPlaceConfig;
	}

	private List<NombreValorDTO> buildCategories(){
		List<NombreValorDTO> nombreValorDTO = new ArrayList<>();
		for (CategoryEnum category : CategoryEnum.values()) {
			NombreValorDTO nombre = new NombreValorDTO();
			nombre.setKey(category.name());
			nombre.setValue(category.getName());
			nombreValorDTO.add(nombre);
		}
		return nombreValorDTO;
	}

	private Components getEnabledComponents(){
		Components components = new Components();
		components.setTwitter(true);
		components.setFacebook(true);
		components.setComments(true);
		components.setMessages(true);
		return components;
	}

}
