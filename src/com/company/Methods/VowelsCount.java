package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int count = getVowels(line);
        System.out.println(count);
    }

    private static int getVowels(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.toLowerCase().charAt(i);
            if (symbol == 'a' || symbol == 'e'
                    || symbol == 'i' || symbol == 'o'
                    || symbol == 'y' || symbol == 'u') {
                count++;
            }
        }
        return count;
    }
}
