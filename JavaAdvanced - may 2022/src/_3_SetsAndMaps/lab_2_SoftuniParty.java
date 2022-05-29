package _3_SetsAndMaps;

/*
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When a guest comes, you have to check if he/she exists on any of the two reservation lists.
All reservation numbers will be with 8 chars. All VIP numbers start with a digit.
There will be 2 command lines:
•	First is "PARTY" - the party is on and guests start coming.
•	The second is "END" - then the party is over, and no more guests will come.
The output shows all guests, who didn't come to the party (VIP must be first).


Examples

Input	                Output
7IK9Yo0h                2
9NoBUajQ                7IK9Yo0h
Ce8vwPmE                tSzE5t0p
SVQXQCbc
tSzE5t0p
PARTY
9NoBUajQ
Ce8vwPmE
SVQXQCbc
END
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class lab_2_SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> invitations = new TreeSet<>();
        while (!input.equals("PARTY")) {
            invitations.add(input);
            input = scanner.nextLine();
        }
        while (!input.equals("END")) {
            invitations.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(invitations.size());
        invitations.forEach(e -> System.out.println(e));
    }
}
