package com.java8.a.IntroduccionToLambda;

import java.util.Comparator;

public class ComparatorLambadaExample {

	public static void main(String[] args) {

		// -----------------------------------------------------------------------------------
		/* prior Java 8 - Legacy way */
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2); //0 -> o1==o2, 1 -> o1>o2, -1 -> o1<o2
			}
		};
		
		System.out.println("Result of the comparator prior to Java 8 is : " + comparator.compare(3, 2));
		
		// -----------------------------------------------------------------------------------
		/* Java 8 lambda */
		// () -> {};
		
		Comparator<Integer> comparatorLambdaLong = (Integer a, Integer b) -> {return a.compareTo(b);};
		
		Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b); // Una sola linea. No es necesario la palabra "return"
		
		System.out.println("\nResult of the comparator after Java 8 is (using lambdas): " + comparatorLambdaLong.compare(3, 2));
		System.out.println("Result of the comparator after Java 8 is (using lambdas): " + comparatorLambda.compare(3, 2));
		
		Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b); //No es necesario añadir el tipo de dato a los argumentos de entrada
		System.out.println("Result of the comparator after Java 8 is (using lambdas): " + comparatorLambda1.compare(3, 2));
	}
}
