package Advanced._3_SetsAndMaps;

/*
Write a program that reads some text from the console and counts the occurrences
of each character in it. Print the results in alphabetical (lexicographical) order.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ex_4_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();
        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (char symbol : text) {
            countSymbols.putIfAbsent(symbol, 0);
            countSymbols.put(symbol, countSymbols.get(symbol) + 1);
        }

        countSymbols.forEach((k, v) -> System.out.println(k + ": " + v + " time/s"));
    }
}
