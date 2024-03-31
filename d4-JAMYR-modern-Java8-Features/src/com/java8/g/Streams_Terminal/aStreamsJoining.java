package com.java8.g.Streams_Terminal;

import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class aStreamsJoining {
	
	public static String joining_1() {
		String collect = StudentDataBase.getAllStudents()
		.stream()
//		.map((student) -> student.getName())
		.map(Student::getName)
		.collect(Collectors.joining());
		
		return collect;
	}
	
	public static String joining_2() {
		String collect = StudentDataBase.getAllStudents()
		.stream()
//		.map((student) -> student.getName())
		.map(Student::getName)
		.collect(Collectors.joining("-"));
		
		return collect;
	}
	
	public static String joining_3() {
		String collect = StudentDataBase.getAllStudents()
		.stream()
//		.map((student) -> student.getName())
		.map(Student::getName)
		.collect(Collectors.joining("-", "(", ")"));
		
		return collect;
	}

	public static void main(String[] args) {
		System.out.println("joining_1: " + joining_1());
		System.out.println("\njoining_2: " + joining_2());
		System.out.println("\njoining_3: " + joining_3());
	}

}
