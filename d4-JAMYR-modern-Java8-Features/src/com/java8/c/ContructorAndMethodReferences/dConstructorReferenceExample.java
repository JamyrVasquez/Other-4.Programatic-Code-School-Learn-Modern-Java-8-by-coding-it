package com.java8.c.ContructorAndMethodReferences;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class dConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    static Function<String, Student> studentFunction = Student::new;

    public static void main(String[] args) {
        System.out.println(studentSupplier.get());

        System.out.println(studentFunction.apply("ABC"));
    }
}
