package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.function.UnaryOperator;

public class jUnaryOperatorExample {

	static UnaryOperator<String> unaryOperator = (s) -> s.concat("Default");

	public static void main(String[] args) {

		System.out.println(unaryOperator.apply("java8 "));
	}

}
