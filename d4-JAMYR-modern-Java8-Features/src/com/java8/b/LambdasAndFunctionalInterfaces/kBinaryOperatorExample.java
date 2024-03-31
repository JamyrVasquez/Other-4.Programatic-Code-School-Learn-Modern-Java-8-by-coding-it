package com.java8.b.LambdasAndFunctionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class kBinaryOperatorExample {

    static BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {

        System.out.println(binaryOperator.apply(3,4));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("\nResult of MaxBy is : " + maxBy.apply(4,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("\nResult of MinBy is : " + minBy.apply(4,5));
    }
}
