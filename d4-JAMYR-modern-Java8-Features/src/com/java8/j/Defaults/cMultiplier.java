package com.java8.j.Defaults;

import java.util.List;

public interface cMultiplier {

	int multiply(List<Integer> integerList);
	
	default int size(List<Integer> integerList) { //Default methods can be overridden
		System.out.println("Inside of Multiplier Interface");
		return integerList.size();
	}
	
	static boolean isEmpty(List<Integer> integerList) { //Default methods can NOT be overridden
		return integerList!=null && integerList.size()>0;
	}
}
