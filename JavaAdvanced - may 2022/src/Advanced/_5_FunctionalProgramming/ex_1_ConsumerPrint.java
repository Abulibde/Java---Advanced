package Advanced._5_FunctionalProgramming;

/*
Write a program that reads a collection of strings,
separated by one or more whitespaces, from the console
and then prints them onto the console. Each string should
be printed on a new line. Use a Consumer<T>.


Examples
Input	                                Output
Peter George Alex	                    Peter
                                        George
                                        Alex

 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ex_1_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> line = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> print = System.out::println;

        line.forEach(print);

    }
}
