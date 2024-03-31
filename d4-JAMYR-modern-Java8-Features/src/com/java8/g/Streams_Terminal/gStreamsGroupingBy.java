package com.java8.g.Streams_Terminal;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class gStreamsGroupingBy {
	
	//groupingBy with 2 parameters ----------------------------------------------------------------------------------------------------------
	public static void calculateTopGpaPerGrade() {
		Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy((s) -> s.getGradeLevel(), Collectors.maxBy(Comparator.comparing((s) -> s.getGpa()))));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		
		System.out.println("studentMapOptional: " + studentMapOptional);
		
		Map<Integer, Student> studentMap = StudentDataBase.getAllStudents().stream()
//				.collect(Collectors.groupingBy((s) -> s.getGradeLevel(), Collectors
//						.collectingAndThen(Collectors.maxBy(Comparator.comparing((s) -> s.getGpa())), (s) -> s.get())));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors
						.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional<Student>::get)));
		System.out.println("\nstudentMap: " + studentMap);
	}
	
	public static void calculateLeastGpaPerGrade() {
		Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy((s) -> s.getGradeLevel(), Collectors.minBy(Comparator.comparing((s) -> s.getGpa()))));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.minBy(Comparator.comparing(Student::getGpa))));
		
		System.out.println("studentMapOptional: " + studentMapOptional);
		
		Map<Integer, Student> studentMap = StudentDataBase.getAllStudents().stream()
//				.collect(Collectors.groupingBy((s) -> s.getGradeLevel(), Collectors
//						.collectingAndThen(Collectors.minBy(Comparator.comparing((s) -> s.getGpa())), (s) -> s.get())));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors
						.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional<Student>::get)));
		System.out.println("\nstudentMap: " + studentMap);
	}
	
	public static void main(String[] args) {
		System.out.println("-------------------------- groupingBy WITH TWO PARAMETERS --------------------------");
		System.out.println("<- calculateTopGpaPerGrade() ->");
		calculateTopGpaPerGrade(); //Obtenemos el Studiante con el mayor GPA por Grado
		
		System.out.println("\n\n<- calculateLeastGpaPerGrade() ->");
		calculateLeastGpaPerGrade(); //Obtenemos el Studiante con el menor GPA por Grado
		
	}

}
