package com.java8.f.NumericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class aNumericStream {

	public static int sumOfNumbers(List<Integer> integerList) {
		Integer result = integerList.stream()
				.reduce(0, (x, y) -> x + y); //Every time the stream passes and element, it's going to perform unboxing of that Integer to convert to int
//				.reduce(0, (x, y) -> {return  (x + y);});
				

		return result;
	}
	
	public static int sumOfNNumbersIntStream() {
		int sum = IntStream.rangeClosed(1, 6) // 1,2,3,4,5,6
				.sum();

		return sum;
	}

	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		System.out.println("Sum of N Numbers: " + sumOfNumbers(integerList));
		
		System.out.println("Sum of N Numbers using IntStream: " + sumOfNNumbersIntStream());
	}

}
