package com.viagging.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.PriceRange;
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
		marketPlaceConfig.setCategories(CategoryEnum.getKeyValues());
		marketPlaceConfig.setPrices(PriceRange.getKeyValues());
		return marketPlaceConfig;
	}
	
}
