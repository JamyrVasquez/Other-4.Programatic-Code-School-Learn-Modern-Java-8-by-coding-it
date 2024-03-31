package com.java8.b.LambdasAndFunctionalInterfaces;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class lSupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> { //"Supplier no recibe ningun parametro"
            return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
        };

        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println("Studen is: " + studentSupplier.get());

        System.out.println("\nStudens are: " + listSupplier.get());
    }
}
