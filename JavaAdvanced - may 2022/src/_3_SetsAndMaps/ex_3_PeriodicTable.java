package _3_SetsAndMaps;

/*
You are given an n number of chemical compounds. You need to keep track of all
chemical elements used in the compounds and at the end print all unique ones in ascending order:

Examples
Input	        Output
4               Ce Ee Mo O
Ce O
Mo O Ce
Ee
Mo

 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ex_3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < numberOfCompounds; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            //compounds.addAll(Arrays.stream(input).toList());
            for (int j = 0; j < input.length; j++) {
                compounds.add(input[j]);
            }
        }

        compounds.forEach(s -> System.out.print(s + " "));
    }
}
