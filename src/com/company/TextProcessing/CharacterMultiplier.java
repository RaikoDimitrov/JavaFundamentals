package com.company.TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        char[] text1 = data[0].toCharArray();
        char[] text2 = data[1].toCharArray();
        int sum = 0;
        int shorterText = Math.min(text1.length, text2.length);
        int largerText = Math.max(text1.length, text2.length);
        for (int i = 0; i < largerText; i++) {
            if (i < shorterText) {
                sum += text1[i] * text2[i];
            }else if (text1.length > text2.length) {
                sum += text1[i];
            }else sum += text2[i];
        }
        System.out.println(sum);
    }
}
