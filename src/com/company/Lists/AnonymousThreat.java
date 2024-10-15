package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = scanner.nextLine();

        while (!line.equals("3:1")) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch(command) {
                case "merge":
                    List<String> result = new ArrayList<>();
                    int start = Math.max(0, Integer.parseInt(data[1]));
                    int end = Math.min(Integer.parseInt(data[2]), strings.size() - 1);
                    //add everything before merge
                    if (start > 0 && start < strings.size()) result = strings.subList(0, start);
                    //merge
                    if (start < strings.size()) {
                        List<String> mergedElements = strings.subList(start, end + 1);
                        String merged = "";
                        for (String mergedElement : mergedElements) {
                            merged += mergedElement;
                        }
                        result.add(merged);
                    }
                    //add everything after merge
                    if (end != strings.size() - 1) result.addAll(strings.subList(end + 1, strings.size()));
                    if (!result.isEmpty()) strings = result;
                    break;
                case "divide":
                    result = new ArrayList<>();
                    int index = Integer.parseInt(data[1]);
                    int partitions = Integer.parseInt(data[2]);
                    String element = strings.get(index);
                    if (element.length() % partitions == 0) {
                        int symbols = element.length() / partitions;
                        for (int i = 0; i < partitions; i++) {
                            result.add(element.substring(0, symbols));
                            element = element.substring(symbols);
                        }
                        strings.remove(index);
                        strings.addAll(index, result);
                    } else {
                        int symbols = element.length() / partitions;
                        for (int i = 0; i < partitions; i++) {
                            if (i == partitions - 1) {
                                result.add(element);
                            } else {
                                result.add(element.substring(0, symbols));
                                element = element.substring(symbols);
                            }
                        }
                        strings.remove(index);
                        strings.addAll(index, result);
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        strings.forEach(s -> System.out.print(s + " "));
    }
}
