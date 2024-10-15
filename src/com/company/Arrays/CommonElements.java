package Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");

        for (String second : arr2) {
            for (String first : arr1) {
                if (second.equals(first)) {
                    System.out.print(first + " ");
                }
            }
        }
    }
}
