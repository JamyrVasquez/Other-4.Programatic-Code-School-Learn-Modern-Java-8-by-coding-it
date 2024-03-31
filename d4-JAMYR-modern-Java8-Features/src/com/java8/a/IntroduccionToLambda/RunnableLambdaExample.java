package com.java8.a.IntroduccionToLambda;

public class RunnableLambdaExample {

	public static void main(String[] args) {

		// -----------------------------------------------------------------------------------
		/* prior Java 8 - Legacy way */

		// Creando una clase anonima - Se necesita mucho codigo para crear una instancia
		// de una "Functional Interface"
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable 1");

			}
		};

		new Thread(runnable).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable before Java 8 version 2\n");

			}
		}).start();

		// -----------------------------------------------------------------------------------
		/* Java 8 lambda */
		// () -> {};

		Runnable runnableLambda = () -> {
			System.out.println("Inside Runnable 2");
		};

		
//		Implementando la interfaz Runnable en una sola línea. Porque solo se ejecuta una sola linea
		Runnable runnableLambda1 = () -> System.out.println("Inside Runnable 3"); 
		
		new Thread(runnableLambda).start();
		new Thread(runnableLambda1).start();

		new Thread(() -> System.out.println("Inside Runnable 4")).start();
	}
}
