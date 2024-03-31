package com.java8.d.LambdasAndLocalVariables;

import java.util.function.Consumer;

public class bLambdaVariable2 {

    static int value = 4;

    public static void main(String[] args) {
//        int value = 4;  //local variable

        //No es posible modificar "value" en el scope de lambda,
        Consumer<Integer> c1 = (i) -> {
            value++;    //Variable used in lambda expression should be final or effectively final
            System.out.println(value + i);
        };

        //value = 6; //No se puede hacer esto
        c1.accept(4);
    }
}
