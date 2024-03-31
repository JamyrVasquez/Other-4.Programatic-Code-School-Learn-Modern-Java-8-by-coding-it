package com.java8.e.StreamsApi;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class mStreamOfGenerateIterate {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach((item) -> System.out.println(item));
        //stringStream.forEach(System.out::println);

        System.out.println("\n-> Iterate <-");
        Stream.iterate(1, x->x*2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n-> Generate <-");
        Supplier<Integer> integerSupplier = () -> new Random().nextInt();
        //Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }

    private static Integer get() {
        return new Random().nextInt();
    }
}
