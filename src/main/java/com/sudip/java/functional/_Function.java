package com.sudip.java.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        // Function - > takes 1 argument and produces 1 result
        int i = incrementByone(1);
        System.out.println(i);
        int integer = incrementByOneFunction.apply(1);

        int integer2 = multiplyByTenFunction.apply(2);
        System.out.println(integer2);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 argument and produces 1 result

        System.out.println(incrementByOneAndMultiplyBy(4,100));
        System.out.println(integerBiFunction.apply(4,100));
    }

    private static Function<Integer, Integer> incrementByOneFunction =
            number -> number +1;

    private static int incrementByone(int n) {
        return n +1;
    }

    private static int incrementByOneAndMultiplyBy(int numberToAdd, int numberToMult){

        return (numberToAdd+1) * numberToMult;
    }

    private  static BiFunction<Integer, Integer, Integer> integerBiFunction =
            (numbertoAdd , numbertoMultiply) ->
                    (numbertoAdd + 1) * numbertoMultiply;

    private static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;


    private static Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
            incrementByOneFunction.andThen(multiplyByTenFunction);

}
