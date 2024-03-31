package com.java8.f.NumericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class eNumericStreamMap {

	public static List<Integer> mapToObject() {
		List<Integer> result = IntStream.rangeClosed(1, 5)
			.mapToObj((i) -> {
//			return new Integer(i); //Deprecated
			return Integer.valueOf(i);
			})
			.collect(Collectors.toList());
		
		return result;
	}
	
	public static long mapToLong() {
		long sum = IntStream.rangeClosed(1, 5) //intSream
				//i is passed form the intStream
				.mapToLong((i) -> i)	//convert intStream to longStream
				.sum();

		return sum;
	}
	
	public static double mapToDouble() {
		double sum = IntStream.rangeClosed(1, 5) //intSream
				//i is passed form the intStream
				.mapToDouble((i) -> i)	//convert intStream to doubleStream
				.sum();

		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("mapToObj: " + mapToObject());
		
		System.out.println("\nmapToLong - sum: " + mapToLong());
		
		System.out.println("\nmapToDouble - sum: " + mapToDouble());
	}
}
