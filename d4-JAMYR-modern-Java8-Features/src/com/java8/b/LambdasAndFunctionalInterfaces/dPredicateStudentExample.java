package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class dPredicateStudentExample {
	
	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
	
	public static void filterStudentsByGradeLevel() {
		System.out.println("\n--> filterStudentsByGradeLevel <--");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student) -> {
			if(p1.test(student)) {
				System.out.println(student);
			}
		}); //Hemos usado un "Consumer" que utiliza un predicado
	}
	
	public static void filterStudentsByGpa() {
		System.out.println("\n--> filterStudentsByGpa <--");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student) -> {
			if(p2.test(student)) {
				System.out.println(student);
			}
		}); //Hemos usado un "Consumer" que utiliza un predicado
	}
	
	public static void filterStudentsByGradeLavelOrGpaNegate() {
		System.out.println("\n--> filterStudentsByGradeLavelOrGpaNegate <--");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student) -> {
			if(p1.or(p2).negate().test(student)) {
				System.out.println(student);
			}
		}); //Hemos usado un "Consumer" que utiliza un predicado
	}

	public static void main(String[] args) {
		
		filterStudentsByGradeLevel();
		
		filterStudentsByGpa();
		
		filterStudentsByGradeLavelOrGpaNegate();
	}
}
