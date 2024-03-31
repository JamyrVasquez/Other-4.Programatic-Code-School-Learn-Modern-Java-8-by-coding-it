package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class aStreamExample {

    public static void main(String[] args) {

        //student name and their activities in a map --------------------------------
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMap);

        //Other way ----------------------------------------------------------------
        Map<String, List<String>> studentMap1 = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap((student) -> student.getName(), (student) -> student.getActivities()));
        System.out.println("\n\n" + studentMap1);

        //--------------------------------------------------------------------------
        Map<String, List<String>> studentMap2 = StudentDataBase.getAllStudents().stream()
                .filter((student) -> student.getGradeLevel() >= 3)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("\n\n" + studentMap2);

        //--------------------------------------------------------------------------
        Predicate<Student> studentPredicate = (student) -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = (student) -> student.getGpa() >= 3.9;

        Map<String, List<String>> studentMap3 = StudentDataBase.getAllStudents().stream()
                .filter(studentPredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("\n\n" + studentMap3);

        //Parallel stream-------------------------------------------------------------
        Map<String, List<String>> studentMap4 = StudentDataBase.getAllStudents().parallelStream()
                .filter(studentPredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("\n\n<-PARALLEL STREAM->\n" + studentMap4);

        //--------------------------------------------------------------------------
        System.out.println("\n\n<-USIN peek Method->");
        Map<String, List<String>> studentMap5 = StudentDataBase.getAllStudents().stream()
                .peek((student) -> {
                    System.out.println("-> Starting Point: " + student);
                })
                .filter(studentPredicate)
                .peek((student) -> {
                    System.out.println("--> After 1st filter: " + student);
                })
                .filter(studentGpaPredicate)
                .peek((student) -> {
                    System.out.println("---> After 2nd filter: " + student);
                })
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("\n" + studentMap5);
    }
}
