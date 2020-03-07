package com.sudip.java.functional;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println(getDbConnectionUrl());
        System.out.println(getDbConnectionSupplier.get());
    }

    private static String getDbConnectionUrl() {
        return "jdbc:localhost://5432";
    }

    private static Supplier<String> getDbConnectionSupplier =
            () -> "jdbc:localhost://5432";

}
