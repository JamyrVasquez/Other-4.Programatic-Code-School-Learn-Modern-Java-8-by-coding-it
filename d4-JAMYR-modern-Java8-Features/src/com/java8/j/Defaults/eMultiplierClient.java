package com.java8.j.Defaults;

import java.util.Arrays;
import java.util.List;

public class eMultiplierClient {

	public static void main(String[] args) {

		cMultiplier multiplier = new dMultiplierImpl();
		
		List<Integer> integerList = Arrays.asList(1, 3, 5);
		
		System.out.println("Result is: " + multiplier.multiply(integerList));
		System.out.println("\nDefault method size is: " + multiplier.size(integerList));
		System.out.println("\nStatic method isEmpty is: " + cMultiplier.isEmpty(integerList));
	}

}
