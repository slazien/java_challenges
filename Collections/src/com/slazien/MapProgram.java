package com.slazien;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "Compiled, high-level, OO, platform-independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "Interpreted, OO, high-level programming language with dynamic semantics");
        languages.put("Algol", "Algorithmic language");
        System.out.println(languages.put("Basic", "Beginners all purpose symbolic instruction code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the Map");
        } else {
            languages.put("Java", "This course is about Java");
        }

        System.out.println("====================================================");

//        languages.remove("Lisp");
        if (languages.remove("Algol", "Algorithmic language")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key-value pair not found");
        }

        if (languages.replace("Lisp", "Therein lies madness", "A functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaces");
        }

//        System.out.println(languages.replace("Scala", "This will not be added"));

        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
