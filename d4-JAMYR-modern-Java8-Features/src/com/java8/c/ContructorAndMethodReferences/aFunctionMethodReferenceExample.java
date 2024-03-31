package com.java8.c.ContructorAndMethodReferences;

import java.util.function.Function;

public class aFunctionMethodReferenceExample {

    static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();

    static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("java8 - Lambda"));

        System.out.println(toUpperCaseMethodReference.apply("java8 - Method Reference"));
    }
}
