package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class kStreamsMatch {

    //------------------------------------------------------------------------------------------------
    public static boolean allMatch(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch((student) -> student.getGpa()>=3.5); //Se va a validar que todos los estudiantes tengan un GPA >= a 3.9
    }

    //------------------------------------------------------------------------------------------------
    public static boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch((student) -> student.getGpa()>=4); //Se va a validar que todos los estudiantes tengan un GPA >= a 3.9
    }
    //------------------------------------------------------------------------------------------------
    public static boolean noneMatch(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch((student) -> student.getGpa()>=4.1); //Se va a validar que todos los estudiantes tengan un GPA >= a 3.9
    }

    public static void main(String[] args) {
        System.out.println("Result of All Match: " + allMatch());
        System.out.println("\nResult of Any Match: " + anyMatch());
        System.out.println("\nResult of None Match: " + noneMatch());
    }
}
