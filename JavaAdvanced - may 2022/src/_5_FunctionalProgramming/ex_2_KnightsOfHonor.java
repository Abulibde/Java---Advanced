package _5_FunctionalProgramming;

/*
Write a program that reads a collection of names as strings from
the console and then appends "Sir" in front of every name and
prints it back onto the console. Use a Consumer<T>.



Examples
Input	                                    Output
Peter George Alex Stan	                    Sir Peter
                                            Sir George
                                            Sir Alex
                                            Sir Stan

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ex_2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Consumer<String> print = e -> System.out.printf("Sir %s%n", e);

        names.forEach(print);
    }
}
