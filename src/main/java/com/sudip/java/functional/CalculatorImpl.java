package com.sudip.java.functional;

import java.util.function.Function;

interface Calculator{
    //void switchOn();

    void sum(int input);
}

public class CalculatorImpl {

    // () -> {body};

    public static void main(String[] args) {

        /*Calculator calculator = () -> System.out.println("Switch On");

        calculator.switchOn();*/

        Calculator calculator = System.out::println;
    }


}
