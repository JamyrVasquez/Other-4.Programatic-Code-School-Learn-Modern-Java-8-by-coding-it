package com.java8.j.Defaults;

public class iClient123 implements fInterface1, gInterface2, hInterface3{
	
	@Override
	public void methodA() {
		System.out.println("Inside Method A " + iClient123.class);
	}
	
	//Precedence of the methods
	//1 -> class the implements the interface
	//2 -> the sub interface that extends the interface
	
	public static void main(String[] args) {
		iClient123 client123 = new iClient123();
		client123.methodA(); //resolve to the child implementation
		client123.methodB();
		client123.methodC();
		
		
	}

}
