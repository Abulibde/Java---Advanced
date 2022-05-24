package Advanced._5_FunctionalProgramming;

/*
3.	Count Uppercase Words
Write a program that reads one line of text from the console.
Print the count of words that start with an Uppercase letter,
after that print all these words in the same order, as you found them in the text.
Use a Predicate<String>.


Examples
Input	                                                                        Output
The following example shows how to use Predicate	                            2
                                                                                The
                                                                                Predicate
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lab_3_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Predicate<String> upperCase = w -> Character.isUpperCase(w.charAt(0));


        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(upperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());

        System.out.println(String.join(System.lineSeparator(), uppercaseWords));
    }
}
