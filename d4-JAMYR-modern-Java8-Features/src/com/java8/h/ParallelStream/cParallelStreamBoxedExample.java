package com.java8.h.ParallelStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class cParallelStreamBoxedExample {

	public static int sequencialSum(List<Integer> integerList) {
		long start = System.currentTimeMillis();

		Integer sum = integerList.stream().reduce(0, (x, y) -> x + y);

		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration in Sequential Stream : " + duration + " milliseconds");

		return sum;
	}

	public static int parallelSum(List<Integer> integerList) {
		long start = System.currentTimeMillis();

		Integer sum = integerList.parallelStream().reduce(0, (x, y) -> x + y); //Extra effort to perform the unboxing from Integer to int

		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration in Parallel Stream : " + duration + " milliseconds");

		return sum;
	}

	public static void main(String[] args) {
		List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
		
		sequencialSum(integerList);
		
		parallelSum(integerList);
	}
}
