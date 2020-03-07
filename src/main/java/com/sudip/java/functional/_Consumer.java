package com.sudip.java.functional;


import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer maria = new Customer("maria","9999");
        greetCustomer(maria);

        // functional interface consumer way

        greetCustomerConsumer.accept(maria);

        // biconsumer way

        greetCustomerConsumerV2.accept(maria,false);

    }

    private static void greetCustomer(Customer customer){

        System.out.println("Hello "+customer.customerName+", thanks for registering "+ customer.customerPhone);

    }

    private static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello "+customer.customerName+", thanks for registering "+ customer.customerPhone);

    private static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =
            (customer, checkPhtobedisplayed) ->
                    System.out.println(
                            "Hello "+customer.customerName+", thanks for registering "+ (checkPhtobedisplayed ? customer.customerPhone:"******"));

    static class Customer {

        private final String customerName;
        private final String customerPhone;

        public Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }
    }
}
