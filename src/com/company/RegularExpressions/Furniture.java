package com.company.RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[>]{2}(?<name>[\\w]+)[<]{2}(?<price>[\\d.]+)!(?<quantity>[\\d]+)$");
        List<String> furniture = new ArrayList<>();
        double totalPrice = 0;

        while (!line.equals("Purchase")) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String name = matcher.group("name");
                Double price = Double.parseDouble(matcher.group("price"));
                Double quantity = Double.parseDouble(matcher.group("quantity"));
                furniture.add(name);
                totalPrice = price * quantity;
            }
            line = scanner.nextLine();
        }
        //print
        System.out.println("Bought furniture: ");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spent: %.2f", totalPrice);
    }
}
