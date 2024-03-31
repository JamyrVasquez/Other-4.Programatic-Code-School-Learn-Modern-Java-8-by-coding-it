package com.java8.f.NumericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class cNumericStreamSumMaxMinAverage {

	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 50).sum();
		System.out.println("Sum is: " + sum);
		
		OptionalInt optionalMax = IntStream.rangeClosed(1, 50).max();
		System.out.println("\nMax: " + (optionalMax.isPresent() ? optionalMax.getAsInt() : 0));
		
		OptionalInt optionalMin = IntStream.rangeClosed(1, 50).min();
		System.out.println("\nMin: " + (optionalMin.isPresent() ? optionalMin.getAsInt() : 0));
		
		OptionalDouble optionalAverage = IntStream.rangeClosed(1, 50).average();
		System.out.println("\nAverage: " + (optionalAverage.isPresent() ? optionalAverage.getAsDouble() : "No average"));
	}
}
