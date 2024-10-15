package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        passLength(password);
        passLetterAndDigits(password);
        passAtLeastTwoDigits(password);

        if (passLength(password) && passLetterAndDigits(password) && passAtLeastTwoDigits(password)) {
            System.out.println("Password is valid.");
        }
        if (!passLength(password)) {
            System.out.println("Password must be between 6 and 10 characters.");
        }
        if (!passLetterAndDigits(password)) {
            System.out.println("Password must consist only letters and digits.");
        }
        if (!passAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits.");
        }
    }

    private static boolean passAtLeastTwoDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                if (counter == 2) return true;
                }
        }
        return false;
    }

    private static boolean passLetterAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.toLowerCase().charAt(i);
            if ((symbol < 48 || symbol > 57) && (symbol < 97 || symbol > 122)) {
                return false;
            }
        }
        return true;
    }

    private static boolean passLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }
}
