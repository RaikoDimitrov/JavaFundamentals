package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestOfThreeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int smallestNum = getSmallestNum(num1, num2, num3);
        System.out.println(smallestNum);
    }
    public static int getSmallestNum(int num1, int num2, int num3) {
        int[] nums = {num1, num2, num3};
        Arrays.sort(nums);
        return nums[0];

    }
}
