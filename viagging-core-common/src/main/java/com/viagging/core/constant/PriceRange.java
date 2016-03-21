package com.viagging.core.constant;

import java.util.ArrayList;
import java.util.List;

import com.viagging.util.Range;

public enum PriceRange {

	PRECIO_1(0, 300),
	
	PRECIO_2(300, 450),
	
	PRECIO_3(450, 600),
	
	PRECIO_4(600, -1);
	
	int low;
	
	int high;
	
	private PriceRange(int low, int high){
		this.low = low;
		this.high = high;
	}
	
	private int getLow(){
		return this.low;
	}
	
	private int getHigh(){
		return this.high;
	}
	
	public static List<Range> getKeyValues() {
		List<Range> prices = new ArrayList<>();
		for(PriceRange priceRange : PriceRange.values()){
			Range range = new Range();
			range.setLow(priceRange.getLow());
			range.setHigh(priceRange.getHigh());
			prices.add(range);
		}
		return prices;
	}
	
}
