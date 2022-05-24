package Advanced._5_FunctionalProgramming;

/*
1.	Sort Even Numbers
Write a program that reads one line of Integers separated by ", ".
•	Print the even numbers.
•	Sort them in ascending order.
•	Print them again.
Use 2 Lambda Expresions to do so.


Examples
Input	                                        Output
4, 2, 1, 3, 5, 7, 1, 4, 2, 12	                4, 2, 4, 2, 12
                                                2, 2, 4, 4, 12

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class lab_1_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String output = input.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        System.out.println(input.stream()
                .sorted()
                .map((String::valueOf))
                .collect(Collectors.joining(", ")));



    }
}
