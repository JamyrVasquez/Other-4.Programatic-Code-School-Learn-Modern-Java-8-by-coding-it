package com.java8.j.Defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class bDefaultMethods2 {
	
	static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
	
	static Comparator<Student> nameComparator = Comparator.comparing(Student::getName); //"Student" es el dato de entrada.
	static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);
	
	//-------------------------------------------------------------------------------------------------------------------
	public static void sortByName(List<Student> studentList) {
//		Comparator<Student> nameComparator = Comparator.comparing((student) -> student.getName());
//		Comparator<Student> nameComparator = Comparator.comparing((Student student) -> student.getName());
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		
		studentList.sort(nameComparator);
		
		System.out.println("\nAfter SortByName: ");
		studentList.forEach(studentConsumer);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	public static void sortByGpa(List<Student> studentList) {
//		Comparator<Object> nameComparator = Comparator.comparing((student) -> ((Student) student).getGpa()).reversed();
//		Comparator<Student> nameComparator = Comparator.comparing((Student student) -> student.getGpa).reversed();
//		Comparator<Student> nameComparator = Comparator.comparing(Student::getGpa).reversed();
		Comparator<Student> nameComparator = Comparator.comparingDouble(Student::getGpa).reversed();
		
		studentList.sort(nameComparator);
		
		System.out.println("\nAfter SortByGPA: ");
		studentList.forEach(studentConsumer);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	public static void compartatorChaining(List<Student> studentList) {		
		studentList.sort(gradeComparator.thenComparing(nameComparator));
		
		System.out.println("\nAfter comparatorChaining: ");
		studentList.forEach(studentConsumer);
	}
	//-------------------------------------------------------------------------------------------------------------------
	public static void sortWithNullValues(List<Student> studentList) {
		Comparator<Student> nullsFirst = Comparator.nullsFirst(nameComparator);
		studentList.sort(nullsFirst);
		
		System.out.println("\nAfter sortWithNullValues - FIRST: ");
		studentList.forEach(studentConsumer);
		
		Comparator<Student> nullsLast = Comparator.nullsLast(nameComparator);
		studentList.sort(nullsLast);
		
		System.out.println("\nAfter sortWithNullValues - LAST: ");
		studentList.forEach(studentConsumer);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
//		System.out.println(studentList);
		System.out.println("Before Sort - Original List");
		studentList.forEach(studentConsumer);
		
//		sortByName(studentList);
//		
//		sortByGpa(studentList);
//		
//		compartatorChaining(studentList);
		
//		List<Student> studentListWithNull = StudentDataBase.getAllStudentsWithNullLast();	//No funciona
//		sortWithNullValues(studentListWithNull);											//No funciona
		sortWithNullValues(studentList);	
	}

}
