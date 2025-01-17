package com.java8.b.LambdasAndFunctionalInterfaces;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class iBiFunctionExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students,
			studentPredicate) -> {
		Map<String, Double> studentGradeMap = new HashMap<>();

		students.forEach((student) -> {
			if (studentPredicate.test(student)) {
				studentGradeMap.put(student.getName(), student.getGpa());
			}
		});

		return studentGradeMap;
	};

	public static void main(String[] args) {

		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), dPredicateStudentExample.p2));
	}
}
