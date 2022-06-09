package _5_FunctionalProgramming;

/*
Write a simple program that reads a set of numbers
from the console and finds the smallest of the numbers
using a simple Function<Integer[], Integer>.


Examples
Input	                            Output
1 4 3 2 1 7 13                  	1

 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ex_3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallestNumber = arr -> Arrays.stream(arr).min().getAsInt();

        System.out.println(smallestNumber.apply(numbers));
    }
}
