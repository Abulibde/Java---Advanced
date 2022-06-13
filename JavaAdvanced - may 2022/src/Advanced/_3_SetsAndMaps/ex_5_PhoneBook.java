package Advanced._3_SetsAndMaps;

/*
Write a program that receives some info from the console about people and their phone numbers.
You are free to choose how the data is entered. Each entry should have just one name and
one number (both of them strings). If you receive a name that already exists in the phonebook,
simply update its number.
After filling this simple phonebook, upon receiving the command "search",
your program should be able to perform a search of contact by name and print her details
in the format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist.".


Examples
Input	                                Output
John-0888080808                         Contact Maria does not exist.
search                                  John -> 0888080808
Maria
John
stop
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex_5_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String[] contact = scanner.nextLine().split("-");
        while (!contact[0].equals("search")) {
            String name = contact[0];
            String phone = contact[1];

            phoneBook.putIfAbsent(name, "");
            phoneBook.put(name, phone);

            contact = scanner.nextLine().split("-");
        }

        String searchContact = scanner.nextLine();

        while (!searchContact.equals("stop")) {
            if (!phoneBook.containsKey(searchContact)) {
                System.out.println("Contact " + searchContact + " does not exist.");
            } else {
                System.out.println(searchContact + " -> " + phoneBook.get(searchContact));
            }

            searchContact = scanner.nextLine();
        }
    }
}
