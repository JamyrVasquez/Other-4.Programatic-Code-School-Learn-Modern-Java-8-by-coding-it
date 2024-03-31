package com.java8.d.LambdasAndLocalVariables;

import java.util.function.Consumer;

public class aLambdaVariable1 {

    public static void main(String[] args) {
    	/*Any variable that is declared inside a method is called a local variable*/
        int i = 0;

        //---------------------------------------------------------------------------
        /*Not allowed to use the same the local variable name as lambda parameters. Variable 'i' is already defined in the scope*/
        /*Consumer<Integer> c1 = (i) -> {
            System.out.println("Value is: " + i);
        };*/

        
        
        //---------------------------------------------------------------------------
        /*Not allowed to use the same the local variable name inside the lambda body.*/
        /*Consumer<Integer> c1 = (i2) -> {
            int i=2;
            System.out.println("Value is: " + i);
        };*/
    }
}
