package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class hFunctionStudentExample {
	
	static Function<List<Student>, Map<String, Double>> studentFunction = (students) -> {
		Map<String, Double> studentGradmap =  new HashMap<>();
		
		students.forEach((student) -> {
			if(dPredicateStudentExample.p1.test(student)) { //We are reusing a predicate
				studentGradmap.put(student.getName(), student.getGpa());
			}
		});
		
		return studentGradmap;
	};

	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));

	}

}
