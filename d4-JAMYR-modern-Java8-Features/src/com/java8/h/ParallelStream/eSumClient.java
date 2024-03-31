package com.java8.h.ParallelStream;

import java.util.stream.IntStream;

public class eSumClient {

	public static void main(String[] args) {
		dSum sum = new dSum();
		
//		IntStream.rangeClosed(1, 1000)
//		.forEach((num) -> sum.performSum(num));
//		IntStream.rangeClosed(1, 1000)
//		.forEach(sum::performSum);		//500500
		
		IntStream.rangeClosed(1, 1000)
		.parallel()
		.forEach(sum::performSum);		//The value changes every time
		
		System.out.println("Total: " + sum.getTotal());
		
		
		//Recomendation: IF YOU HAVE MUTABLE VARIABLES, DONT USE PARALLEL
	}

}
