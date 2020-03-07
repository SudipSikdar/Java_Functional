package com.sudip.java.functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sudip.java.functional._Stream.Gender.FEMALE;
import static com.sudip.java.functional._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Sudip", 40, MALE),
                new Person("Sachin", 35, MALE),
                new Person("Dona", 45, FEMALE),
                new Person("Shalini", 30, FEMALE)
        );

        /*Function<Person, String> personGenderFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream()
                .map(personGenderFunction)
                .mapToInt(length)
                .forEach(println);*/

        boolean allMatchFemale = people.stream()
                .allMatch(person -> person.gender == FEMALE);

        System.out.println(allMatchFemale);

        // sort the Persons

        List<Person> personList = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        System.out.println(personList.forEach(person -> person.getName()));




    }

    static class Person{

        private final String name;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        private final int age;
        private final Gender gender;

        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        FEMALE, MALE
    }
}
