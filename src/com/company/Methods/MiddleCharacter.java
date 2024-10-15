package Methods;

import java.util.Scanner;

public class MiddleCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        middleChar(line);
    }

    private static void middleChar(String line) {
        if (line.length() % 2 == 0) {
            System.out.print(line.charAt(line.length() / 2 - 1));
            System.out.print(line.charAt(line.length() / 2));
        } else {
            System.out.print(line.charAt(line.length() / 2));
        }
    }
}
