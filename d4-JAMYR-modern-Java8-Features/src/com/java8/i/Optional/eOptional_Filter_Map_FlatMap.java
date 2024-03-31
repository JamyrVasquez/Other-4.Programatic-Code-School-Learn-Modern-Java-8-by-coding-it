package com.java8.i.Optional;

import java.util.Optional;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class eOptional_Filter_Map_FlatMap {

	// filter
	public static void optionalFilter() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Creamos un Optional<Student>

		studentOptional.filter((student) -> student.getGpa() >= 3.5)
				.ifPresent((student) -> System.out.println(student));
	}

	// map
	public static void optionalMap() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Creamos un Optional<Student>

		if(studentOptional.isPresent()) {
			Optional<String> stringOptional = studentOptional.filter((student) -> student.getGpa() >= 3.5).map((student) -> student.getName());
			System.out.println(stringOptional.get());
		}
	}

	// flatmap
	public static void optionalFlatMap() {
//		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Creamos un Optional<Student>
		Optional<Student> studentOptional = Optional.ofNullable(null); //Creamos un Optional<Student>
		
		//As we are going to extract un Optional (Optional<Bike>) which is inside of another Optional (Optional<Student>), we need to use "flatMap()" method
//		Optional<Bike> optionalBike = studentOptional.filter((student) -> student.getGpa() >= 3.5).flatMap((student) -> student.getBike());
		Optional<Bike> optionalBike = studentOptional.filter((student) -> student.getGpa() >= 3.5).flatMap(Student::getBike);
		System.out.println("optionalBike: " + optionalBike);
		
//		Optional<String> optionalString = studentOptional.filter((student) -> student.getGpa() >= 3.5).flatMap((student) -> student.getBike()).map((bike) -> bike.getName());
		Optional<String> optionalString = studentOptional
				.filter((student) -> student.getGpa() >= 3.5) //Optional<Student <Optional<Bike>>
				.flatMap(Student::getBike)					  //Optional<Bike>
				.map(Bike::getName);						  //Optional<String>
		System.out.println("optionalString: " + optionalString);
		
//		studentOptional.filter((student) -> student.getGpa() >= 3.5).flatMap((student) -> student.getBike()).ifPresent((bike) -> System.out.println(bike));
		studentOptional.filter((student) -> student.getGpa() >= 3.5).flatMap(Student::getBike).ifPresent(System.out::println);
		

	}

	public static void main(String[] args) {
		System.out.println("optionalFilter: ");
		optionalFilter();
		
		System.out.println("\n\noptionalMap: ");
		optionalMap();
		
		System.out.println("\n\noptionalFlatMap: ");
		optionalFlatMap();
	}

}
