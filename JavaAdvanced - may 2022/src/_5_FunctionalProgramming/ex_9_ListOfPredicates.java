package _5_FunctionalProgramming;

/*
Find all numbers in the range 1..N that is divisible
by the numbers of a given sequence. Use predicates.

Examples
Input	                            Output
10
1 1 1 2	                            2 4 6 8 10


100
2 5 10 20	                        20 40 60 80 100

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex_9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersToDivide = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivide : numbersToDivide) {
                if (number % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }

    }
}
