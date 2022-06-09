package _5_FunctionalProgramming;

/*
Write a program that reverses a collection and
removes elements that are divisible by a given integer n.


Examples
Input	                    Output
1 2 3 4 5 6
2	                        5 3 1

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex_5_ReverseAndExecute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> divide = number -> number % n == 0;

        numbers.removeIf(divide);
        Collections.reverse(numbers);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
