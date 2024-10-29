package com.company.ExamPreparation1;

import java.util.Scanner;

public class ImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //can be replaced with StringBuilder
        String message = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Decode")) {
            String[] data = line.split("\\|");
            String command = data[0];
            switch (command) {
                case "Move" -> {
                    int numberOfLetters = Integer.parseInt(data[1]);
                    message = move(message, numberOfLetters);
                }
                case "Insert" -> {
                    int index = Integer.parseInt(data[1]);
                    String value = data[2];
                    message = insert(message, index, value);
                }
                case "ChangeAll" -> {
                    String substring = data[1];
                    String replacement = data[2];
                    message = changeAll(message, substring, replacement);
                }
                default -> throw new IllegalStateException("Unknown command: " + command);
            }

            line = scanner.nextLine();
        }
        //print
        System.out.print("The decrypted message is: " + message);
    }

    private static String changeAll(String message, String substring, String replacement) {
        return message.replace(substring, replacement);
    }

    private static String insert(String message, int index, String value) {
        String firstPart = message.substring(0, index);
        String secondPart = message.substring(index);
        message = firstPart + value + secondPart;
        return message;
    }

    private static String move(String message, int numberOfLetters) {
        String firstPart = message.substring(0, numberOfLetters);
        String secondPart = message.substring(numberOfLetters);
        message = secondPart + firstPart;
        return message;
    }

}
