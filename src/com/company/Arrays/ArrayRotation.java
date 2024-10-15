package Arrays;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            String temp = line[0];
            for (int j = 0; j < line.length - 1; j++) {
                line[j] = line[j + 1];
            }
            line[line.length - 1] = temp;
        }
        System.out.println(String.join(" ", line));
    }
}
