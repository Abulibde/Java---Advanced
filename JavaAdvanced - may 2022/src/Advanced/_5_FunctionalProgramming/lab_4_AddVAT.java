package Advanced._5_FunctionalProgramming;

/*
Write a program that reads one line of Double prices separated by ", ".
Print the prices with added VATs for all of them. Format them to the
2nd digit after the decimal point. The order of the prices must remain the same.
Use an UnaryOperator<Double>.


Examples
Input	                                Output
1.38, 2.56, 4.4	                        Prices with VAT:
                                        1.66
                                        3.07
                                        5.28
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class lab_4_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Double> printer = d -> System.out.printf("%.2f%n", d);

        UnaryOperator<Double> addVAT = p -> p * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVAT)
                .sorted()
                .forEach(printer);


    }
}
