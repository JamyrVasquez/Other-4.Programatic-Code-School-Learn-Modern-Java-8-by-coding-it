package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class fStreamsFilter {

    public static List<Student> filterStudents() {
        return StudentDataBase.getAllStudents().stream()    //Stream<Student>
                .filter((student) -> student.getGender().equals("female"))  //Stream<Student> //filters and sends only the student whose gender is female
                //.filter((s) -> s.getGpa()>=3.9)
                //.sorted() //No funciona, para que funcione la clase "Student" debe implementar la interfaz "Comparable"
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("filterStudents: " + filterStudents());

        System.out.println("\n\nfilterStudents - Method reference");
        filterStudents().forEach(System.out::println);

        System.out.println("\n\nfilterStudents - Lambda Expression");
        filterStudents().forEach((s) -> System.out.println(s));
    }
}
