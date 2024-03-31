package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.Optional;

public class lStreamFindAnyFirst {

    //------------------------------------------------------------------------------------------------
    public static Optional<Student> findAnyStudent(){
        Optional<Student> any = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();

        return any;
    }

    //------------------------------------------------------------------------------------------------
    public static Optional<Student> findFirstStudent(){
        Optional<Student> first = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();

        return first;
    }

    public static void main(String[] args) {
        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if(studentOptionalFindAny.isPresent()){
            System.out.println("Find any - Found The student: " + studentOptionalFindAny.get());
        } else {
            System.out.println("Find any - Student Not Found");
        }

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if(studentOptionalFindFirst.isPresent()){
            System.out.println("Find first - Found The student: " + studentOptionalFindFirst.get());
        } else {
            System.out.println("Find first - Student Not Found");
        }
    }
}
