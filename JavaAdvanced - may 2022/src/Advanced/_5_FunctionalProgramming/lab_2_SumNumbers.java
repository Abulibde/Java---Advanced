package Advanced._5_FunctionalProgramming;

/*
Write a program that reads one line of Integers separated by ", ".
Print the count of the numbers and their sum.
Use a Function<String, Integer>.
Examples
Input	Output
4, 2, 1, 3, 5, 7, 1, 4, 2, 12	Count = 10
Sum = 41
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class lab_2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormater = e -> "Count - " + e.size();

        Function<List<Integer>, Integer> sumAllElements = l -> l.stream().mapToInt(e -> e).sum();

        Function<Integer, String> sumFormatter = e -> "Sum - " + e;

        String countOutput = countFormater.apply(numbers);
        System.out.println(countOutput);


        int sum = sumAllElements.apply(numbers);
        String sumOutput = sumFormatter.apply(sum);
        System.out.println(sumOutput);


    }
}
