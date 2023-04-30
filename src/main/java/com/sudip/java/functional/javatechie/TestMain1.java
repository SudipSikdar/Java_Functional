package com.sudip.java.functional.javatechie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain1 {

    public static void main(String[] args) {
        // Assume that you have a list of employee in various department, write a program to find the highest paid employee in each department;

        List<Employee> employees = Stream.of(new Employee("1", "Sudip", "DMS", 1000),
                        new Employee("2", "Sachin", "DMS", 2000),
                        new Employee("3", "Sujit", "ECPR", 1000),
                        new Employee("4", "Salma", "ROP", 4000),
                        new Employee("5", "Asit", "ECPR", 3000))
                .toList();

        Map<String, List<Employee>> empMap = employees.stream().collect(Collectors.groupingBy(Employee::dept));

        System.out.println(empMap);

        // approach 1

        Comparator<Employee> comparator = Comparator.comparing(Employee::salary);
        Map<String, Optional<Employee>> optionalMap = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::dept,
                                Collectors.reducing(
                                        BinaryOperator.maxBy(comparator)
                                )
                        )
                );

        optionalMap.forEach((key, value) -> System.out.println(value.get().dept + ":" + value.get().name + ":" + value.get().salary));

        // approach 2

        Map<String, Employee> employeeMap = employees.stream()
                .collect(
                        Collectors.toMap(Employee::dept,
                                Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Employee::salary)
                                )
                        )
                );

        employeeMap.forEach((s, employee) -> System.out.println(employee));
    }

    record Employee(String id, String name, String dept, double salary) {
    }
}
