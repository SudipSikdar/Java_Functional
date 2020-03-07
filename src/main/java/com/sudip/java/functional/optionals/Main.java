package com.sudip.java.functional.optionals;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<IllegalStateException> stateCorrupt = () -> new IllegalStateException("state corrupt");
        Object val = Optional.ofNullable("test")
                .orElseThrow(stateCorrupt);

        Optional.ofNullable("hello")
                .ifPresent(System.out::println);

        Optional.ofNullable("abc@abc.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to -> "+email),
                        () -> System.out.println("can't send email"));


        System.out.println(val);
    }

}
