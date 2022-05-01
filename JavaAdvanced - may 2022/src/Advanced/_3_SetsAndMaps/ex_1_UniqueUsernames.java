package Advanced._3_SetsAndMaps;

/*
Write a simple program that reads from the console a sequence of usernames and keeps a
collection with only the unique ones. Print the collection on the console in order of insertion:

Examples

Input	    Output
6           Hello
Hello       World
Hello       Greetings
Hello
World
Hello
Greetings
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ex_1_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfUsernames = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < numberOfUsernames; i++) {
            String input = scanner.nextLine();
            usernames.add(input);
        }

        usernames.forEach(System.out::println);

    }
}
