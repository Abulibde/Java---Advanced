package _5_FunctionalProgramming;

/*
On the first line, you are given a list of numbers.
On the next lines you are passed different commands
that you need to apply to all numbers in the
list: "add" -> adds 1; "multiply" -> multiplies by 2;
"subtract" -> subtracts 1; "print" -> prints all numbers
on a new line. The input will end with an "end" command,
after which the result must be printed.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ex_4_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> sumFunc = list -> list.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunc = list -> list.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunc = list -> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Consumer<Integer> printer = list -> System.out.printf("%d ", list);


        String line = scanner.nextLine();
        while (!line.equals("end")) {
            switch (line) {
                case "add":
                    numbers = sumFunc.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunc.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunc.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(printer);
                    System.out.println();
                    break;
            }


            line = scanner.nextLine();
        }
    }
}
