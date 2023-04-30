package com.sudip.java.functional.javatechie;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {

    private static final Object object = new Object();

    private static final IntPredicate evenCond = e -> e % 2 == 0;
    private static final IntPredicate oddCond = e -> e % 2 != 0;

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(oddCond));
        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(evenCond));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printNumber(IntPredicate condition) {
        IntStream.rangeClosed(1, 10).filter(condition).forEach(EvenOddPrinter::execute);
    }

    public static void execute(int no) {

        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
