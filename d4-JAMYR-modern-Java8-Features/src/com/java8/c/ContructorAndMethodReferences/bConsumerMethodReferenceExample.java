package com.java8.c.ContructorAndMethodReferences;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.function.Consumer;

public class bConsumerMethodReferenceExample {

    static Consumer<Student> c1 = p -> System.out.println(p);

    //Classname::methodName
    static Consumer<Student> c11 = System.out::println;

    //Classname::instanceMethodName
    static Consumer<Student> c2 = Student::printListOfActivities;

    public static void main(String[] args) {

        System.out.println("Consumer with Lambda");
        StudentDataBase.getAllStudents().forEach(c1);

        System.out.println("\nConsumer with Reference Method");
        StudentDataBase.getAllStudents().forEach(c11);

        System.out.println("\nConsumer with Reference Method - using an instanceMethod");
        StudentDataBase.getAllStudents().forEach(c2);

    }
}
