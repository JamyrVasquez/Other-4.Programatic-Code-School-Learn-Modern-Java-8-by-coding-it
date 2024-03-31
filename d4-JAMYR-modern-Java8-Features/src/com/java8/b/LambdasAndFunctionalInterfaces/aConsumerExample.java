package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class aConsumerExample {
	
	static Consumer<Student> c2 = (student) -> System.out.println(student); // Creamos la implementacion de "Consumer"
	static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
	static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

	public static void printName() {
		System.out.println("\n--> printName <--");
		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(c2); // "forEach" recibe una implementación de "Consumer".
	}

	public static void printNameActivities() {
		System.out.println("\n--> printNameActivities <--");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(c3.andThen(c4)); //Consumer chaining
	}
	
	public static void printNameActivitiesUsingCondition() {
		System.out.println("\n--> printNameActivitiesUsingCondition <--");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student -> {
			if(student.getGradeLevel()>=3 && student.getGpa()>=3.9) {
				c3.andThen(c4).accept(student);
			}
		}));
	}

	public static void main(String[] args) {

		// Creamos una implementacion rapida de una "Functional Interface"
		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase()); // No es necesario añadir el tipo de dato a "s".
		c1.accept("java8");

		printName();

		printNameActivities();
		
		printNameActivitiesUsingCondition();
		
//		List<Integer> testListPrint = Arrays.asList(1, 2, 3, 4, 5, 6);
//		System.out.println(testListPrint);
	}

}
