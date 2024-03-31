package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.function.Function;

public class fFunctionExample {
	
	static Function<String, String> function = (name) -> name.toUpperCase(); //Recibe un String y retorna un String
	
	static Function<String, String> addSomeString = (name) -> name.concat(" default");

	public static void main(String[] args) {
		System.out.println("Result is: " + function.apply("java8"));
		
		System.out.println("Result of andThen is: " + function.andThen(addSomeString).apply("java8"));
		
		System.out.println("Result of compose is: " + function.compose(addSomeString).apply("java8")); //Primero se ejecuta "addSomeString" y luego "function"
	}

}
