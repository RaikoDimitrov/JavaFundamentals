package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + arr[i + 1] == number) {
                System.out.println(arr[i] + " " + arr[i + 1]);
            }
        }
    }
}
