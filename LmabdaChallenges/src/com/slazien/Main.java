package com.slazien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 1
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        // 2, 3
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));

        // 4, 5
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        // 6, 7
        Supplier<String> iLoveJava = () -> {
            return "I love Java!";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("\n=================\n");

        // 8, 9, 10
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "olivier",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();

        topNames2015.forEach(name -> {
            String upperName = name.substring(0, 1).toUpperCase().concat(name.substring(1));
            firstUpperCaseList.add(upperName);
        });

        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("\n=================\n");

        // 11, 12
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase().concat(name.substring(1)))
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n=================\n");

        long startsWithA = topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase())
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("No. of names starting with 'A': " + startsWithA);

        System.out.println("\n=================\n");

        // 13, 14
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
//                .count();
                .collect(Collectors.toList());
    }

    public static String everySecondCharacter(Function<String, String> function, String inputString) {
        return function.apply(inputString);
    }
}
