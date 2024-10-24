package com.company.TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            int product = digit * multiplier + remainder;
            if (i == 0) {
                sb.insert(0, product);
            } else {
                int digittoAdd = product % 10;
                remainder = product / 10;
                sb.insert(0, digittoAdd);
            }
        }
        while (sb.charAt('0') == 0 && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
