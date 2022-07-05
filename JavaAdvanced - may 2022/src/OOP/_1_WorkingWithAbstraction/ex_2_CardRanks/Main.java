package OOP._1_WorkingWithAbstraction.ex_2_CardRanks;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");

        Arrays.stream(Cards.values())
                .forEach(card-> System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card.name()));
    }
}
