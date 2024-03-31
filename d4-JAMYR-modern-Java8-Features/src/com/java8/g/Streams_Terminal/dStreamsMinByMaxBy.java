package com.java8.g.Streams_Terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class dStreamsMinByMaxBy {
	
	public static Optional<Student> minBy_example() {
		Optional<Student> result = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.minBy(Comparator.comparing((student)-> student.getGpa())));
				.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
		
		return result;
	}
	
	public static Optional<Student> maxBy_example() {
		Optional<Student> result = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing((student)-> student.getGpa())));
//				.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println("minBy_example: " + minBy_example());
		
		System.out.println("\nmaxBy_example: " + maxBy_example());
	}

}
