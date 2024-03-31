package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.function.Predicate;

public class cPredicateExample {
	
	static Predicate<Integer> p = (i) -> { return  i%2==0;};	
	static Predicate<Integer> p1 = (i) -> i%2==0; //If the lambda body is a single line, we can avoid curly braces and the word "return"
	static Predicate<Integer> p2 = (i) -> i%5==0;
	
	public static void predicateAnd() {
		System.out.println("\n--> predicateAnd <--");
		System.out.println("Predicate And result is : " + p1.and(p2).test(10)); //Predicate chaining
		System.out.println("Predicate And result is : " + p1.and(p2).test(9)); //Predicate chaining
	}
	
	public static void predicateOr() {
		System.out.println("\n--> predicateOr <--");
		System.out.println("Predicate OR result is : " + p1.or(p2).test(10)); //Predicate chaining
		System.out.println("Predicate OR result is : " + p1.or(p2).test(8)); //Predicate chaining
	}
	
	public static void predicateNegate() {
		System.out.println("\n--> predicateNegate <--");
		System.out.println("Predicate OR result is : " + p1.or(p2).negate().test(8)); //Predicate chaining
	}

	public static void main(String[] args) {
	
		System.out.println(p.test(4));
		System.out.println(p1.test(5));
		
		predicateAnd();
		predicateOr();
		predicateNegate();
		
		
	}

}
