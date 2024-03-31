package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class bBiConsumerExample {
	
	public static void nameAndActivities() {
		System.out.println("\n--> nameAndActivities <--");
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student) -> biConsumer.accept(student.getName(), student.getActivities()));
	}

	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumer = (a, b) -> {
			System.out.println("a: " + a + " , b: " + b);
		};
		
		biConsumer.accept("java7", "java8");
		
		BiConsumer<Integer, Integer> multiply = (a, b) -> {
			System.out.println("Multiplication is: " + (a*b));
		};

		BiConsumer<Integer, Integer> division = (a, b) -> {
			System.out.println("Division is: " + (a/b));
		};
		
//		multiply.andThen(division.andThen(division)).andThen(multiply).accept(10, 5);
		multiply.andThen(division).accept(10, 5);
		
		nameAndActivities();
	}

}
