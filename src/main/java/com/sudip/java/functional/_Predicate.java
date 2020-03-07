package com.sudip.java.functional;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000000000"));

        System.out.println("with predicate");

        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));

        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000"));
    }

    private static boolean isPhoneNumberValid(String s) {

        return s.startsWith("07") && s.length() == 11;
    }

    private static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    private static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");

}
