package com.java8.j.Defaults;

import java.util.List;

public class dMultiplierImpl implements cMultiplier {

	@Override
	public int multiply(List<Integer> integerList) {
		Integer result = integerList.stream().reduce(1, (x,y) -> x*y);
		
		return result;
	}
	
//	@Override
	public int size(List<Integer> integerList) { //It's no possible to use default
		System.out.println("Inside of MultiplierImpl Class");
		return integerList.size();
	}
}
