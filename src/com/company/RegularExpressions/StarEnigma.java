package com.company.RegularExpressions;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^[^\\-@!:>]*@(?<planet>[A-Za-z]+)[^\\-@!:>]*:(?<population>[\\d]+)[^\\-@!:>]*!(?<attackType>[AD])![^\\-@!:>]*->(?<soldierCount>[\\d]+)[^\\-@!:>]*$");
        Map<String, Integer> attackedPlanets = new TreeMap<>();
        Map<String, Integer> destroyedPlanets = new TreeMap<>();

        for (int i = 0; i <= n; i++) {
            String text = scanner.nextLine();
            int count = findCount(text);
            String message = decryptedMessage(count, text);
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String planet = matcher.group("planet");
                if (matcher.group("attackType").equalsIgnoreCase("a")) {
                    attackedPlanets.putIfAbsent(planet, 0);
                    attackedPlanets.put(planet, attackedPlanets.get(planet) + 1);
                }else {
                    destroyedPlanets.putIfAbsent(planet, 0);
                    destroyedPlanets.put(planet, destroyedPlanets.get(planet) + 1);
                }
                System.out.println();
            }
        }
        //print
        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.forEach((k, v) -> System.out.println("-> " + k));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.forEach((k, v) -> System.out.println("-> " + k));
    }

    private static String decryptedMessage(int count, String text) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int newChar = text.charAt(i) - count;
            message.append((char)newChar);
        }
        return message.toString();
    }

    private static int findCount(String text) {
        Pattern compile = Pattern.compile("[starSTAR]");
        Matcher matcher = compile.matcher(text);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
