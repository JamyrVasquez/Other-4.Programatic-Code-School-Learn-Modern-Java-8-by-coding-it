package com.java8.g.Streams_Terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class cStreamsMapping {
	
	public static void main(String[] args) {
		List<String> nameList = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
				.collect(Collectors.mapping((student) -> student.getName(), Collectors.toList()));
		
//		List<String> nameList = StudentDataBase.getAllStudents().stream().map((student) -> student.getName()).collect(Collectors.toList()); //The same as before
		System.out.println("nameList: " + nameList);
		
		Set<String> nameSet = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		System.out.println("\nnameSet: " + nameSet);
	}

}
