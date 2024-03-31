package com.java8.b.LambdasAndFunctionalInterfaces;

public class gFunctionExample1 {
	
	public static String performConcat(String str) {
		return fFunctionExample.addSomeString.apply(str);
	}

	public static void main(String[] args) {
		
		String result = performConcat("Hello");
		
		System.out.println(result);
	}
}
;