package Advanced._5_FunctionalProgramming;

/*
Write a program that is using a custom function (written by you)
to find the smallest integer in a sequence of integers.
The input could have more than one space. Your task is to collect
the integers from the console, find the smallest one and
print its index (if more than one such elements exist,
print the index of the rightmost one).

Hints
•	Use a Function<List<Integer>, Integer> or something similar.


Examples
Input	                        Output
1 2 3 0 4 5 6	                3
123 10 11 3	                    3

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ex_7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestOne = list -> {
            int minElement = Integer.MAX_VALUE;
            int lastSmallestIndex;

            for (Integer integer : list) {
                if (integer < minElement) {
                    minElement = integer;
                }
            }
            lastSmallestIndex = list.lastIndexOf(minElement);
            return lastSmallestIndex;
        };

        System.out.println(findSmallestOne.apply(numbers));

    }
}
