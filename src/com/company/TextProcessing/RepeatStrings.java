package com.company.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        List<String> repeated= new ArrayList<>();

        for (String word : words) {
            repeated.add(repeat(word, word.length()));
        }
        String result = String.join("", repeated);
        System.out.println(result);
    }

    private static String repeat(String word, int repetitions) {
        char[] repeated = new char[word.length() * repetitions];
        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word.charAt(i % word.length());
        }
        return new String(repeated);
    }
}
