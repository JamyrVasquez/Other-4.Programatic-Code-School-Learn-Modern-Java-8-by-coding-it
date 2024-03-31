package com.java8.j.Defaults;

public interface gInterface2 extends fInterface1{

	default void methodB() {
		System.out.println("Inside Method B");
	}
	
	@Override
	default void methodA() {
		System.out.println("Inside Method A " + gInterface2.class);
	}

}
