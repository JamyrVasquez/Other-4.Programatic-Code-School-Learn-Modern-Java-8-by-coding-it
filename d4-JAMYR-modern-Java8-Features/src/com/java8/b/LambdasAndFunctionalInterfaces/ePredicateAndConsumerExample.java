package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class ePredicateAndConsumerExample {

	Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

	BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;

	BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out
			.println(name + " : " + activities);

	Consumer<Student> studentConsumer = (student) -> {
//		if (p1.and(p2).test(student)) { //Predicate chaining
//			studentBiConsumer.accept(student.getName(), student.getActivities());
//		}

		if (biPredicate.test(student.getGradeLevel(), student.getGpa())) { //Utilizando "BiPredicate"
			studentBiConsumer.accept(student.getName(), student.getActivities());
		}
	};

	// ---------------------------------------------------------------------------------------
	public void printNameAndActivities(List<Student> students) {
		System.out.println("\n--> printNameAndActivities <--");
		students.forEach(studentConsumer);
	}

	public void printNameAndActivities2() {
		System.out.println("\n--> printNameAndActivities2 <--");
		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(studentConsumer);
	}

	public static void main(String[] args) {

		// -----------------------------------------------------------------------------------
		List<Student> studentList = StudentDataBase.getAllStudents();
		new ePredicateAndConsumerExample().printNameAndActivities(studentList);

		// -----------------------------------------------------------------------------------
		ePredicateAndConsumerExample a = new ePredicateAndConsumerExample();
		a.printNameAndActivities2();
	}

}
