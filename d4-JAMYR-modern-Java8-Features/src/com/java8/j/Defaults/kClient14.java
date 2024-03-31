package com.java8.j.Defaults;

public class kClient14 implements fInterface1, jinterface4{
	
	@Override
	public void methodA() { //Es obligatorio sobre escribir el metodo cuando los metodos en las interfaces tienen el mismo nombre
		System.out.println("Inside Method A " + kClient14.class);
	}

	public static void main(String[] args) {
		kClient14 client14 = new kClient14();
		client14.methodA();
	}
}
