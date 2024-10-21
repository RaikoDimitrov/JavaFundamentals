package com.company.TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (String s : input) {
            char letterBefore = s.charAt(0);
            char letterAfter = s.charAt(s.length() - 1);
            String digits = s.substring(1, s.length() - 1);
            double number = Double.parseDouble(digits);
            int letterBeforePos = getAlphabetPosition(letterBefore);
            int letterAfterPos = getAlphabetPosition(letterAfter);
            if (Character.isUpperCase(letterBefore)) {
                sum += number / letterBeforePos;
            } else sum += number * letterBeforePos;

            if (Character.isUpperCase(letterAfter)) {
                sum -= letterAfterPos;
            } else sum += letterAfterPos;
        }
        System.out.printf("%.2f", sum);
    }
    static int getAlphabetPosition(char c) {
        return Character.toLowerCase(c) - 96;
    }
}
