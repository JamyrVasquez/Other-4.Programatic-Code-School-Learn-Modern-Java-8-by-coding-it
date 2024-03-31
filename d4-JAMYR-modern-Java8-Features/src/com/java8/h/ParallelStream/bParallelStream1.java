package com.java8.h.ParallelStream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class bParallelStream1 {
	
	   public static List<String> sequentialPrintStudentActivities(){
		   long startTime = System.currentTimeMillis();
		   
	        List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
	                .map(Student::getActivities)    //Stream<List<String>>
	                //.flatMap((activities) -> activities.stream()) //Creamos un "Stream" por cada una de las Listas de Strings
	                .flatMap(Collection::stream) //Stream<String>. Los mismo que arriba pero usando method reference
	                .distinct()
	                .sorted()
	                .collect(Collectors.toList());

	        long endTime = System.currentTimeMillis();
	        System.out.println("Duration to execute the pipeline in SEQUENTIAL: " +  (endTime - startTime));
	        
	        return studentActivities;
	    }
	   
	   public static List<String> parallelPrintStudentActivities(){
		   long startTime = System.currentTimeMillis();
		   
	        List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
	        		.parallel()
	                .map(Student::getActivities)    //Stream<List<String>>
	                //.flatMap((activities) -> activities.stream()) //Creamos un "Stream" por cada una de las Listas de Strings
	                .flatMap(Collection::stream) //Stream<String>. Los mismo que arriba pero usando method reference
	                .distinct()
	                .sorted()
	                .collect(Collectors.toList());
	        
	        long endTime = System.currentTimeMillis();
	        System.out.println("Duration to execute the pipeline in PARALLEL: " +  (endTime - startTime));

	        return studentActivities;
	    }

	public static void main(String[] args) {
		System.out.println("sequentialPrintStudentActivities: " + sequentialPrintStudentActivities());
		
		System.out.println("parallelPrintStudentActivities: " + parallelPrintStudentActivities());
	}

}
