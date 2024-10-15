package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] data = command.split("\\s+");
            if (data[0].equals("Delete")) {
                int element = Integer.parseInt(data[1]);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == element) {
                        list.remove(i);
                        i--;
                    }
                }
            } else if (data[0].equals("Insert")) {
                list.add(Integer.parseInt(data[2]), Integer.parseInt(data[1]));
            }

            command = scanner.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
