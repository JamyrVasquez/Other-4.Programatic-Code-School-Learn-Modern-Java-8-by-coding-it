package com.java8.f.NumericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class dNumericStreamsBoxingUnboxing {
	
	public static List<Integer> boxing() {

		List<Integer> integerList = IntStream.rangeClosed(1, 10)
				.boxed()
				.collect(Collectors.toList());
		
		return integerList;
	}
	
	public static int unBoxing(List<Integer> integerList) {
		//Wrapper to primitive
		IntStream mapToInt = integerList.stream()
//				.mapToInt((integer)-> integer.intValue());
				.mapToInt(Integer::intValue);
		
		return mapToInt.sum();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Boxing: " + boxing());
		
		List<Integer> integerList = boxing();
		System.out.println("Unboxing: " + unBoxing(integerList));
		
	}

}
