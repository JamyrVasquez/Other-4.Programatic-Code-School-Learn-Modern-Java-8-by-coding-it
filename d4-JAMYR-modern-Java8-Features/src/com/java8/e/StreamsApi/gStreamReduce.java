package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.*;

public class gStreamReduce {

    public static int performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                //1
                //3
                //5
                //7
                // a=1, b=1(from stream) => result 1 is returned
                // a=1, b=3(from stream) => result 3 is returned
                // a=3, b=5(from stream) => result 15 is returned
                // a=15, b=7(from stream) => result 105 is returned
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
        Optional<Integer> reduceOpt = integerList.stream()
                .reduce((a, b) -> a * b); //Recibe un "BinaryOperator"

        return reduceOpt;
    }

    public static Optional<Student> getHighestGPAStudent() {
        Optional<Student> result = StudentDataBase.getAllStudents().stream()
                /*.reduce((s1, s2) -> {
                    if (s1.getGpa() > s2.getGpa()) {
                        return s1;
                    } else {
                        return s2;
                    }
                });*/
                .reduce((s1,s2) -> (s1.getGpa()>s2.getGpa() ? s1 : s2)); //Rescribiendo el codigo

        return result;
    }

    //Este código lo añadió Jamyr
    public static Optional<Student> getHighestGPAStudentByJamyr() {
        Optional<Student> result = StudentDataBase.getAllStudents().stream()
                .max(Comparator.comparing((s) -> s.getGpa()));

        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);

        List<Integer> integers1 = new ArrayList<>();

        System.out.println(performMultiplication(integers));

        System.out.println("\n-> performMultiplicationWithoutIdentity <-");
        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());

        System.out.println("\n-> performMultiplicationWithoutIdentity - Empty List <-");
        Optional<Integer> result1 = performMultiplicationWithoutIdentity(integers1);
        System.out.println(result1.isPresent());
        if (result1.isPresent()) {
            System.out.println(result1.get());
        }

        System.out.println("\n-> getHighestGPAStudent <-");
        Optional<Student> studentOptional = getHighestGPAStudent();
        if(getHighestGPAStudent().isPresent()){
            System.out.println(studentOptional.get());
        }

        System.out.println("\n-> getHighestGPAStudentByJamyr <-");
        Optional<Student> studentOptionalByJamyr = getHighestGPAStudentByJamyr();
        if(getHighestGPAStudentByJamyr().isPresent()){
            System.out.println(studentOptionalByJamyr.get());
        }
    }
}
