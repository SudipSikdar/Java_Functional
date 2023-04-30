package com.sudip.java.functional;


@FunctionalInterface
public interface MyFunctionalnterface {
    void m1();

    default void m2() {
        System.out.println("Inside m2");
    }

    default void m3() {
        System.out.println("Inside m3");
    }
}
