package com.company.AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (String word : line) {
            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);
                if (!result.containsKey(symbol)) {
                    result.put(symbol, 1);
                }else {
                    result.put(symbol, result.get(symbol) + 1);
                }
            }
        }
        result.forEach((key, value) -> System.out.printf("%c -> %d%n", key, value));
    }

}
