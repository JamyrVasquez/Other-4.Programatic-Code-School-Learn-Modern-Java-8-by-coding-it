package com.java8.j.Defaults;

public interface fInterface1 {
	
	default void methodA() {
		System.out.println("Inside Method A " + fInterface1.class);
	}
}
