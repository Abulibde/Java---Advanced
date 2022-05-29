package _3_SetsAndMaps;

/*
On the first line, you are given the length of two sets N and M.
On the next N + M lines there are N numbers, that are in the
first set and M numbers that are in the second one. Find all non-repeating
element that appears in both of them, and print them in the same order at the console:
Set with length N = 4: {1, 3, 5, 7}
Set with length M = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}

Examples
Input	        Output
4 3               3 5
1
3
5
7
3
4
5
 */

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ex_2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int mapSize = input[0];
        int elementsToCheck = input[1];
        Set<Integer> numbers = new LinkedHashSet<>();

        for (int i = 0; i < mapSize; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            numbers.add(currentNumber);
        }
        for (int i = 0; i < elementsToCheck; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (numbers.contains(currentNumber)) {
                System.out.print(currentNumber + " ");
            }
        }

    }
}
