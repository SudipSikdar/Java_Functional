package com.sudip.java.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sudip.java.functional.Main.Gender.FEMALE;
import static com.sudip.java.functional.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Sudip", MALE),
                new Person("Sachin", MALE),
                new Person("Dona", FEMALE),
                new Person("Shalini", FEMALE)
        );

        System.out.println("Below is imperative approach");
        List<Person> femalList= new ArrayList<Person>();

        for (Person person:people) {
            if(person.gender.equals(FEMALE)){
                femalList.add(person);
            }
            
        }

        for (Person female:femalList
             ) {
            System.out.println(female);

        }

        System.out.println("Below is declarative approach");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    static class Person{

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
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

