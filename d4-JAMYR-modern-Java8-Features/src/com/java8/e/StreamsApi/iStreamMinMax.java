package com.java8.e.StreamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class iStreamMinMax {

    //MAX --------------------------------------------------------------------------------------------------------------
    public static int maxValue(List<Integer> integerList){
        int maxValue = integerList.stream()
                //6 -> y
                //7 -> y
                //8 -> y
                //9 -> y
                //10 -> y
                //x variable holds the max value for each element in the iteration
                .reduce(0, (x, y) -> x > y ? x : y);

        return maxValue;
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList){
        Optional<Integer> maxValue = integerList.stream()
                .reduce((x, y) -> x > y ? x : y);

        return maxValue;
    }

    //MIN --------------------------------------------------------------------------------------------------------------
    public static int minValue(List<Integer> integerList){
        int minValue = integerList.stream()
                .reduce(0, (x, y) -> x < y ? x : y);

        return minValue;
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList){
        Optional<Integer> minValue = integerList.stream()
                .reduce((x, y) -> x < y ? x : y);

        return minValue;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        //List<Integer> integerList = new ArrayList<>();

        System.out.println("MAX ------------------------------------------------------------------------------");
        int maxValue = maxValue(integerList);
        System.out.println("max value is: " + maxValue);

        System.out.println("\n-> findMaxValueOptional <-");
        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
        System.out.println("Optional Max is: " + maxValueOptional);
        if (maxValueOptional.isPresent()){
            System.out.println("Max Value using optional: " + maxValueOptional.get());
        } else {
            System.out.println("No max value found - input list is empty");
        }

        System.out.println("\n\nMIN ------------------------------------------------------------------------------");
        int minValue = minValue(integerList);
        System.out.println("min value is: " + minValue);

        System.out.println("\n-> findMinValueOptional <-");
        Optional<Integer> minValueOptional = findMinValueOptional(integerList);
        System.out.println("Optional Min is: " + minValueOptional);
        if (minValueOptional.isPresent()){
            System.out.println("Min Value using optional: " + minValueOptional.get());
        } else {
            System.out.println("No min value found - input list is empty");
        }
    }
}
