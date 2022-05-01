package Advanced._3_SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ex_2_SetsOfElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetSize = input[0];
        int secondSetSize = input[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNumber);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNumber);
        }
        for (Integer element : firstSet) {
            if (secondSet.contains(element)) {
                System.out.print(element + " ");
            }
        }

    }
}
