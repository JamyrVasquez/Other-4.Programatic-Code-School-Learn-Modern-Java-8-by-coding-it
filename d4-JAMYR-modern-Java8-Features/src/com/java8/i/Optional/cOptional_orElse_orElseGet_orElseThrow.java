package com.java8.i.Optional;

import java.util.Optional;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class cOptional_orElse_orElseGet_orElseThrow {

	//orElse
	public static String optionalOrElse() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> studentOptional = Optional.ofNullable(null); //Optiona.empty
		
//		String name = studentOptional.map((student) -> student.getName()).orElse("Default");
		String name = studentOptional.map(Student::getName).orElse("Default");
		return name;
	}
	
	//orElseGet
	public static String optionalOrElseGet() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> studentOptional = Optional.ofNullable(null); //Optiona.empty
		
		String name = studentOptional.map(student -> student.getName()).orElseGet(() -> "Default"); //This accepts a "Supplier" functional interface
//		String name = studentOptional.map(Student::getName).orElseGet(() -> "Default");
		return name;
	}
	
	//orElseThrow
	public static String optionalOrElseThrow() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> studentOptional = Optional.ofNullable(null); //Optiona.empty
		
		String name = studentOptional.map(student -> student.getName()).orElseThrow(() -> new RuntimeException("No Data Available"));
//		String name = studentOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Available"));
		return name;
	}
	
	public static void main(String[] args) {
		System.out.println("OrElse: " + optionalOrElse());
		
		System.out.println("\n\nOrElseGet: " + optionalOrElseGet());
		
		System.out.println("\n\nOrElseThrow: " + optionalOrElseThrow());
	}

}
