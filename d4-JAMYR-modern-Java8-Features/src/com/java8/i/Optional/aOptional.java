package com.java8.i.Optional;

import java.util.Optional;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class aOptional {
	
	public static String getStudenName() {
		Student student = StudentDataBase.studentSupplier.get();
//		Student student = null;
		
		if (student != null) {
			return student.getName();
		}
		
		return null;
	}
	
	public static Optional<String> getStudentNameOptional() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> studentOptional = Optional.ofNullable(null); //Optional.empty()
		
		if (studentOptional.isPresent()) {
			studentOptional.get(); //Student -> no lo estoy usando
			Optional<String> optionalString = studentOptional.map((student) -> student.getName());
			return optionalString;
		} 
		
		return Optional.empty();
	}
	
	//No es la mejor manera de hacerlo
	public static String getStudentName_v2() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> studentOptional = Optional.ofNullable(null);
		
		if (studentOptional.isPresent()) {
			String studentName = studentOptional.map(Student::getName).get();
//			String studentName = studentOptional.map((student) -> student.getName()).get();
			return studentName;
		} 
		
		return Optional.empty().toString();
	}

	public static void main(String[] args) {
		
//		String studenName = getStudenName();
//		System.out.println("Length of the student Name: " + studenName.length());
		
		Optional<String> stringOptional = getStudentNameOptional();
		if (stringOptional.isPresent()) {
			System.out.println("The result of calling getStudentNameOptional: " + stringOptional.get());
			System.out.println("Length of the student Name: " + stringOptional.get().length());
		} else {
			System.out.println("Name not found");
		}
		
		System.out.println("\n\nThe result of calling getStudentName_v2: " + getStudentName_v2());
		System.out.println("Length of the student Name: " + getStudentName_v2().length());
	}
}
