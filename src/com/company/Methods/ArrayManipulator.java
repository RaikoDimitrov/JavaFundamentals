package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] data = line.split(" ");
            String command = data[0];
            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(data[1]);
                    if (isValidIndex(index, array.length)) {
                        exchange(array, index);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (data[1].equals("even")) {
                        printEvenMax(array);
                    } else {
                        printOddMax(array);
                    }
                    break;
                case "min":
                    if (data[1].equals("even")) {
                        printEvenMin(array);
                    } else {
                        printOddMin(array);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(data[1]);
                    if (count > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("even")) {
                            printFirstEven(array, count);
                        } else {
                            printFirstOdd(array, count);
                        }
                    }
                    break;
                case "last":
                    count = Integer.parseInt(data[1]);
                    if (count > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("even")) {
                            printLastEven(array, count);
                        } else {
                            printLastOdd(array, count);
                        }
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printOddMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i] && array[i] % 2 != 0) {
                min = array[i];
                index = i;
            }
        }
        if (index == -1) System.out.println("No matches");
        else System.out.println(index);
    }

    private static void printEvenMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i] && array[i] % 2 == 0) {
                min = array[i];
                index = i;
            }
        }
        if (index == -1) System.out.println("No matches");
        else System.out.println(index);
    }

    private static void printFirstOdd(int[] array, int count) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && count > 0) {
                arr[i] = array[i];
                count--;
            } else arr[i] = -1;
        }
        printArr(arr);
    }

    private static void printFirstEven(int[] array, int count) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && count > 0) {
                arr[i] = array[i];
                count--;
            } else arr[i] = -1;
        }
        printArr(arr);
    }

    private static void printLastEven(int[] array, int count) {
        int[] arr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && count > 0) {
                arr[i] = array[i];
                count--;
            } else arr[i] = -1;
        }
        printArr(arr);
    }

    private static void printLastOdd(int[] array, int count) {
        int[] arr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0 && count > 0) {
                arr[i] = array[i];
                count--;
            } else arr[i] = -1;
        }
        printArr(arr);
    }

    private static void printOddMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i] && array[i] % 2 != 0) {
                max = array[i];
                index = i;
            }
        }
        if (index == -1) System.out.println("No matches");
        else System.out.println(index);
    }

    private static void printEvenMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i] && array[i] % 2 == 0) {
                max = array[i];
                index = i;
            }
        }
        if (index == -1) System.out.println("No matches");
        else System.out.println(index);
    }

    private static void exchange(int[] array, int index) {
        int[] firstArr = new int[index + 1];
        int[] secondArr = new int[array.length - index - 1];

        for (int i = 0; i <= index; i++) {
            firstArr[i] = array[i];
        }
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = array[index + 1 + i];
        }
        for (int i = 0; i < array.length; i++) {
            if (i < secondArr.length) {
                array[i] = secondArr[i];
            } else {
                array[i] = firstArr[i - secondArr.length];
            }
        }
    }

    private static boolean isValidIndex(int index, int length) {
        return index >= 0 && index < length;
    }
    public static void printArr(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) count++;
        }
        int[] buffer = new int[count];
        boolean isEmpty = true;
        for (int i = 0; i < nums.length - count; i++) {
            buffer[i] = nums[i];
            isEmpty = false;
        }
        if (isEmpty) System.out.println("[]");
        else System.out.println(Arrays.stream(buffer));
    }
}
