package Advanced._5_FunctionalProgramming;

/*
Write a custom comparator that sorts all even numbers before all odd ones
in ascending order. Pass it to an Arrays.sort() function and print the result.

Examples
Input	                            Output
1 2 3 4 5 6	                        2 4 6 1 3 5
-3 2	                            2 -3

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ex_8_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (num1, num2) -> {
            //logic

            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
    }
}
