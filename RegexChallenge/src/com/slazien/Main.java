package com.slazien;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge1Regex = "I want a bike\\.";
        System.out.println(challenge1.matches(challenge1Regex));

        String challenge2a = "I want a bike.";
        String challenge2b = "I want a ball.";
        String challenge2Regex = "I want a \\w+.*";
        System.out.println(challenge2a.matches(challenge2Regex));
        System.out.println(challenge2b.matches(challenge2Regex));

        Pattern pattern = Pattern.compile(challenge2Regex);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[a-zA-z]+\\.[0-9]+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8RegEx = "[a-zA-Z]+\\.([0-9]+)";
        Pattern pattern1 = Pattern.compile(challenge8RegEx);
        Matcher matcher1 = pattern1.matcher(challenge8);

        while (matcher1.find()) {
            System.out.println(matcher1.group(1));
        }

        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge10RegEx = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern10 = Pattern.compile(challenge10RegEx);
        Matcher matcher10 = pattern10.matcher(challenge10);

        while (matcher10.find()) {
            System.out.println("Occurrence: " + matcher10.start(1) + " to " + (matcher10.end(1) - 1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {11, 1340}";
        String challenge11RegEx = "\\{([0-9]+, [0-9]+)\\}";
        Pattern pattern11 = Pattern.compile(challenge11RegEx);
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()) {
            System.out.println(matcher11.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        String challenge14RegEx = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge12.matches(challenge14RegEx));
        System.out.println(challenge13.matches(challenge14RegEx));
    }
}
