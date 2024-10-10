package com.company.ExamPreparation1;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsPerHour = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int studentsCount = scanner.nextInt();
        int hoursPassed = 0;

        //todo
        while (studentsCount > 0) {
            hoursPassed++;
            if (hoursPassed % 4 != 0) studentsCount -= studentsPerHour;
        }

        System.out.printf("Time nedded: %dh.", hoursPassed);

    }
}
