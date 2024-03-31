package com.java8.e.StreamsApi;

import java.util.ArrayList;
import java.util.stream.Stream;

public class bCollectionVsStream {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("jim");
        names.add("jenny");

        //-------------------------------------------------------
        for (String name: names) {
            System.out.println(name);
        }
        System.out.println("\n");
        for (String name: names) {
            System.out.println(name);
        }

        names.remove(0);
        System.out.println("\n" + names);

        //-------------------------------------------------------
        Stream<String> nameStream = names.stream();
        nameStream.forEach((s) -> System.out.println(s));
        //nameStream.forEach(System.out::println);

    }
}
