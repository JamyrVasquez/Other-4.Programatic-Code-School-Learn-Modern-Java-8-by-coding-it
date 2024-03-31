package com.java8.g.Streams_Terminal;

import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class bStreamsCounting {
	
	public static long count() {
		Long count = StudentDataBase.getAllStudents()
				.stream()
				.filter((student) -> student.getGpa()>=3.9)
				.collect(Collectors.counting()); //Wrapper class
		
//		long count = StudentDataBase.getAllStudents().stream().count(); //Primitive class
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count());
	}

}
