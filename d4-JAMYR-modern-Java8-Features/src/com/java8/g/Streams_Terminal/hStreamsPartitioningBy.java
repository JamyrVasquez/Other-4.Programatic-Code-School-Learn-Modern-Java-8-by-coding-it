package com.java8.g.Streams_Terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class hStreamsPartitioningBy {
	
	public static void partitioningBy_1() {
		Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
		Map<Boolean, List<Student>> partitioningMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy(gpaPredicate));
		
		System.out.println(partitioningMap);
	}
	
	public static void partitioningBy_2() {
		Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
		Map<Boolean, Set<Student>> partitioningMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));
		
		System.out.println(partitioningMap);
	}
	
	public static void main(String[] args) {
		System.out.println("PARTITIONING WITH 1 ARGUMENT");
		partitioningBy_1();
		
		System.out.println("\nPARTITIONING WITH 2 ARGUMENTS");
		partitioningBy_2();
	}
}
