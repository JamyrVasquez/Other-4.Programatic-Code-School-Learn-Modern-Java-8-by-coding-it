package com.java8.f.NumericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class bNumericStreamRanges {

	
	public static void main(String[] args) {
		IntStream range = IntStream.range(1, 50);
		System.out.println("Int Stream Range count: " + range.count());
		IntStream.range(1, 50).forEach((value) -> System.out.print(value + ", " ));
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 50);
		System.out.println("\n\nInt Stream Range Closed count: " + rangeClosed.count());
		IntStream.rangeClosed(1, 50).forEach((value) -> System.out.print(value + ", "));
		
		System.out.println("\n\nLong Stream Range Count: " + LongStream.range(1, 50).count());
		LongStream.range(0, 50).forEach((value) -> System.out.print(value + ", "));
		
		System.out.println("\n\nLong Stream Range Closed Count: " + LongStream.rangeClosed(1, 50).count());
		LongStream.rangeClosed(0, 50).forEach((value) -> System.out.print(value + ", "));
		
		System.out.println("\n\nDouble Stream Range Count: " + IntStream.range(1, 50).asDoubleStream().count());
		IntStream.range(1, 50).asDoubleStream().forEach((value) -> System.out.print(value + ", "));
		
		System.out.println("\n\nDouble Stream Range Closed Count: " + IntStream.rangeClosed(1, 50).asDoubleStream().count());
		IntStream.rangeClosed(1, 50).asDoubleStream().forEach((value) -> System.out.print(value + ", "));
		
	}
}
