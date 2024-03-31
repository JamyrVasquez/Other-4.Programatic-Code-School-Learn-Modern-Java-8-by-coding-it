package com.java8.g.Streams_Terminal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class fStreamsGroupingBy {
	
	//groupingBy with 1 parameter ----------------------------------------------------------------------------------------------------------
	public static void groupStudentsByGender() {
		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy((student) -> student.getGender()));
				.collect(Collectors.groupingBy(Student::getGender));
		
		System.out.println(studentMap);
	}
	
	public static void customizedGroupingBy() {
		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy((student) -> {
					if(student.getGpa() >= 3.9) {
						return "OUTSTANDING";
					} else {
						return "AVERAGE";
					}
				}));
//				.collect(Collectors.groupingBy((student) -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")); //Rescribiendo el codigo

		System.out.println(studentMap);
	}
	
	//groupingBy with 2 parameters ----------------------------------------------------------------------------------------------------------
	public static void twoLevelGrouping_1() {
		Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel,
				Collectors.groupingBy((student) -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
		
		System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_2() {
		Map<Integer, Integer> studentMap = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt((student) -> student.getNoteBooks())));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoteBooks)));

		System.out.println(studentMap);
	}

	public static void twoLevelGrouping_2_1() {
		Map<String, Integer> studentMap = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt((student) -> student.getNoteBooks())));
				.collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getNoteBooks)));

		System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_Jamyr_1() { //This method was added by Jamyr
		Map<Integer, List<String>> studentMap = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.mapping(t -> t.getName(), Collectors.toList())	)	);
//		.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.mapping(Student::getName, Collectors.toList())	)	);
		
		System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_Jamyr_2() { //This method was added by Jamyr, y todo el codigo funciona
		Map<Integer, List<Object>> studentMap = StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.mapping((t) -> {
//					return new Object() {
//						String name = t.getName();
//						int gradeLevel = t.getGradeLevel();
//						
//						@Override
//						public String toString() {
//							return "Student{" + "name='" + name + '\'' + ", gradeLevel=" + gradeLevel + '}';
//						}
//					};
//					
//					/*Object objResult = new Object() {
//						private String name = t.getName();
//						private int gradeLevel = t.getGradeLevel();
//						
//						public String getName() {
//							return name;
//						}
//						public int getGradeLevel() {
//							return gradeLevel;
//						}
//
//						@Override
//						public String toString() {
//							return "Student{" + "name='" + name + '\'' + ", gradeLevel=" + gradeLevel + '}';
//						}
//					};
//					return objResult; */
//				}, Collectors.toList())));
				.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.mapping((t) -> new Object() {
					String name = t.getName();
					int gradeLevel = t.getGradeLevel();
					
					@Override
					public String toString() {
						return "Student{" + "name='" + name + '\'' + ", gradeLevel=" + gradeLevel + '}';
					}
				}, Collectors.toList())));
		
		studentMap.forEach((key, value) -> {
			System.out.println(key + " = ");
			value.forEach((val) -> System.out.println(val)); //Jamyr no pudo acceder a los parametros
		});
//		System.out.println("\n\n"+studentMap);
	}
	
	//groupingBy with 3 parameters ----------------------------------------------------------------------------------------------------------
	public static void threeArgumentGroupBy() {
		LinkedHashMap<String, Set<Student>> studenLinkedHashMap = StudentDataBase.getAllStudents()
		.stream()
//		.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
		.collect(Collectors.groupingBy(student -> student.getGender(), () -> {return new LinkedHashMap<>();}, Collectors.toSet())); //El segundo parametro define el retorno
		
		System.out.println(studenLinkedHashMap);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		System.out.println("-------------------------- groupingBy WITH ONE PARAMETER --------------------------");
		System.out.println("<- groupStudentsByGender() ->");
		groupStudentsByGender();
		
		System.out.println("\n\n<- customizedGroupingBy() ->");
		customizedGroupingBy();
		
		System.out.println("\n\n-------------------------- groupingBy WITH TWO PARAMETERS --------------------------");
		System.out.println("<- twoLevelGrouping_1() ->");
		twoLevelGrouping_1();
		
		System.out.println("\n\n<- twoLevelGrouping_2() ->");
		twoLevelGrouping_2();
		
		System.out.println("\n\n<- twoLevelGrouping_2_1() ->");
		twoLevelGrouping_2_1();
		
		System.out.println("\n\n<- twoLevelGrouping_Jamyr_1() ->");
		twoLevelGrouping_Jamyr_1();
		
		System.out.println("\n\n<- twoLevelGrouping_Jamyr_2() ->");
		twoLevelGrouping_Jamyr_2();
		
		System.out.println("\n\n-------------------------- groupingBy WITH THREE PARAMETERS --------------------------");
		System.out.println("<- threeArgumentGroupBy() ->");
		threeArgumentGroupBy();
		
//		var names = List.of("John", "Peter", "Olaf");
//		var namesAndLength = names.stream().map(n -> new Object() {
//			String name = n;
//			int length = n.length();
//		}).collect(Collectors.toList());
//		System.out.println(namesAndLength);
		
	}
}
