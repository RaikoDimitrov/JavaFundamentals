package com.company.RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //regex
        String nameRegex = "[A-za-z]+";
        String distanceRegex = "[\\d]{1}";

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        for (String name : names) {
            racers.putIfAbsent(name, 0);
        }
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        String line = scanner.nextLine();

        while (!line.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(line);
            StringBuilder sb = new StringBuilder();
            while (nameMatcher.find()) {
                sb.append(nameMatcher.group());
            }
            if (racers.containsKey(sb.toString())) {
                Matcher distanceMather = distancePattern.matcher(line);
                while (distanceMather.find()) {
                    int digit = Integer.parseInt(distanceMather.group());
                    racers.put(sb.toString(), racers.get(sb.toString()) + digit);
                }
            }
            line = scanner.nextLine();
        }
        //print
        List<String> sorted = racers.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3) break;
            String place;
            place = i == 0 ? "1st" : i == 1 ? "2nd" : i == 2 ? "3rd" : "";
            System.out.printf("%s place: %s%n", place, sorted.get(i));
        }

    }
}
