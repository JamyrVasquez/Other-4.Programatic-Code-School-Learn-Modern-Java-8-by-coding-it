package com.java8.h.ParallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class aParallelStream {
	
	public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes) {
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfTimes; i++) {
			supplier.get();
		}
		long endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static int sumSequentialStream() {
		return IntStream.rangeClosed(1, 10000000).sum();
				
	}
	
	public static int sumParallelStream() {
		return IntStream.rangeClosed(1, 10000000)
				.parallel()
				.sum();
				
	}

	public static void main(String[] args) {
		System.out.println("Number of available processor: " + Runtime.getRuntime().availableProcessors());
		
//		System.out.println(sumParallelStream());
//		System.out.println("Parallel Stream Result: " + checkPerformanceResult(ParallelStream::sumParallelStream, 20));
		System.out.println("Parallel Stream Result: " + checkPerformanceResult(() -> sumParallelStream(), 20));
		
//		System.out.println(sumSequentialStream());
//		System.out.println("Sequential Stream Result: " + checkPerformanceResult(ParallelStream::sumSequentialStream, 20));
		System.out.println("Sequential Stream Result: " + checkPerformanceResult(() -> sumSequentialStream(), 20));
	}

}
