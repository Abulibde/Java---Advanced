package _5_FunctionalProgramming;

/*
Write a predicate. Its goal is to check a name for its length and to return true
if the length of the name is less or equal to the passed integer.
You will be given an integer that represents the length you have to use.
On the second line, you will be given a string array with some names.
Print the names, passing the condition in the predicate.


Examples
Input	                                    Output	Input	Output
4
Sara Sam George Mark John	                Sara
                                            Sam
                                            Mark
                                            John
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex_6_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> nameValidator = name -> name.length() <= n;

        names.stream()
                .filter(nameValidator)
                .forEach(System.out::println);
    }
}
