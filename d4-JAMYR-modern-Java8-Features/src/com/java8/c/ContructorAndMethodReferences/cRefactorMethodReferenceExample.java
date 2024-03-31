package com.java8.c.ContructorAndMethodReferences;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.function.Predicate;

public class cRefactorMethodReferenceExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p11 = cRefactorMethodReferenceExample::greaterThanGradeLevel;

    public static boolean greaterThanGradeLevel(Student s){
        return s.getGradeLevel()>=3;
    }

    public static void main(String[] args) {
        System.out.println(p1.test(StudentDataBase.studentSupplier.get())); //Estamos llamando a un supplier

        System.out.println(p11.test(StudentDataBase.studentSupplier.get())); //Estamos llamando a un supplier
    }
}
