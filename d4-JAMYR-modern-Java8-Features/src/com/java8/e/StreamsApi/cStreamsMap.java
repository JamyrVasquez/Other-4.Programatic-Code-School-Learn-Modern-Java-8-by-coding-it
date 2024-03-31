package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class cStreamsMap {

    public static List<String> namesList(){
        List<String> studentList = StudentDataBase.getAllStudents().stream()
                //.map((student) -> student.getName())  //Usando un expresión lambda
                .map(Student::getName) //Usando method reference. Ahora el stream deja de ser de "Stream<Students>" a "Stream<String>"
                .map(String::toUpperCase)//Stream<String> -> uppercase operation on each input
                .collect(Collectors.toList());

        return studentList;
    }
    public static Set<String> namesSet(){
        Set<String> studentSet = StudentDataBase.getAllStudents().stream()
                //.map((student) -> student.getName())  //Usando un expresión lambda
                .map(Student::getName) //Usando method reference. Ahora el stream deja de ser de "Stream<Students>" a "Stream<String>"
                .map(String::toUpperCase)//Stream<String> -> uppercase operation on each input
                .collect(Collectors.toSet()); //Set<String>

        return studentSet;
    }
    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
