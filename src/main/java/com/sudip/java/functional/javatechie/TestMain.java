package com.sudip.java.functional.javatechie;

import com.sudip.java.functional.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        List<User> users = Stream.of(new User("Sudip", "112233", List.of("ss@ss.com", "dd@dd.com")),
                new User("Sachin", "334455", List.of("ss@sc.com", "dd@dc.com")),
                new User("Surya", "223344", List.of("se@ab.com", "dd@ab.com"))).toList();

        System.out.println(users.stream().map(User::phone).collect(Collectors.joining(":")));

        List<String> emailList = users.stream().flatMap(user -> user.emails().stream()).toList();
        System.out.println(emailList);

        String input = "Sudip";

        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);
    }
}
