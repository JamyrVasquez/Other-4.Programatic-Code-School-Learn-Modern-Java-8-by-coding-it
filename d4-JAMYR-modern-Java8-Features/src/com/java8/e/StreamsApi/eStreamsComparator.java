package com.java8.e.StreamsApi;


import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class eStreamsComparator {

    public static List<Student> sortStudentsByName(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                //.sorted(Comparator.comparing((student) -> student.getName()))
                //.sorted(Comparator.comparing((student) -> {return student.getName();}))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpa(){
        return StudentDataBase.getAllStudents().stream()
                //.sorted(Comparator.comparing(Student::getGpa))
                .sorted(Comparator.comparing((student) -> student.getGpa()))
                //.sorted(Comparator.comparing((student) -> {return student.getGpa();}))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpaDesc(){
        return StudentDataBase.getAllStudents().stream()
                //.sorted(Comparator.comparing(Student::getGpa).reversed())
                //.sorted(Comparator.comparing((student) -> ((Student) student).getGpa()).reversed())
                .sorted(Comparator.comparing((student) -> {return ((Student)student).getGpa();}).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("sortStudentsByName: " + sortStudentsByName());

        System.out.println("\n\nStudent sorted by Name: ");
        sortStudentsByName().forEach(System.out::println);

        System.out.println("\n\nStudent sorted by Gpa: ");
        sortStudentsByGpa().forEach(System.out::println);

        System.out.println("\n\nStudent sorted by Gpa Desc: ");
        sortStudentsByGpaDesc().forEach(System.out::println);
    }
}
