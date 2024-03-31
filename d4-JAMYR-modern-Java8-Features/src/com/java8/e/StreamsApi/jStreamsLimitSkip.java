package com.java8.e.StreamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class jStreamsLimitSkip {

    public static Optional<Integer> limit(List<Integer> integers){
        Optional<Integer> result = integers.stream()
                .limit(2) //Solo va dejar pasar los 2 primeros elementos del stream
                .reduce((x, y) -> x + y);

        return result;
    }

    public static Optional<Integer> skip(List<Integer> integers){
        Optional<Integer> result = integers.stream()
                .skip(3) //Se van a saltar los 3 primeros elementos del stream
                .reduce((x, y) -> x + y);

        return result;
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> limitResult = limit(integers);
        if (limitResult.isPresent()){
            System.out.println("The limit result is: " + limitResult.get());
        } else {
            System.out.println("Skip - No input is passed");
        }

        Optional<Integer> skipResult = skip(integers);
        if (skipResult.isPresent()){
            System.out.println("The skip result is: " + skipResult.get());
        } else {
            System.out.println("Skip - No input is passed");
        }
    }
}
