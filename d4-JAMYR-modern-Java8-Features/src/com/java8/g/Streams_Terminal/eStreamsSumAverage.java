package com.java8.g.Streams_Terminal;

import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class eStreamsSumAverage {
	
	public static int sum() {
		Integer result = StudentDataBase.getAllStudents().stream()
//				.collect(Collectors.summingInt((student)->student.getNoteBooks()));
//				.collect(Collectors.summingInt(Student::getNoteBooks));
				.collect(Collectors.summingInt(
						(student) -> {return student.getNoteBooks();}
						));

		return result;
	}
	
	public static double average() {
		Double result = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.averagingInt(Student::getNoteBooks));

		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Total No of notebooks: " + sum());
		
		System.out.println("Average No of notebooks: " + average());
	}

}
