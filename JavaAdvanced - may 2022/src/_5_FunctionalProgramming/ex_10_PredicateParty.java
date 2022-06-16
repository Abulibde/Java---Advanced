package _5_FunctionalProgramming;

/*
The Wire’s parents are on a vacation for the holidays, and he is planning
an epic party at home. Unfortunately, his organizational skills are next
to non-existent, so you are given the task to help him with the reservations.

On the first line, you get a list of all the people that are coming.
On the next lines, until you get the "Party!" command, you may be
asked to double or remove all the people that apply to the given criteria.
There are three different options:

•	Everyone that has a name starts with a given string.
•	Everyone that has a name ending with a given string.
•	Everyone has a name with a given length.

When you print the guests that are coming to the party, you have to
print them in ascending order. If nobody is going,
print "Nobody is going to the party!". See the examples below:

Examples
Input	                                                Output
Peter Misha Stephan
Remove StartsWith P
Double Length 5
Party!	                                                Misha, Misha, Stephan are going to the party!

 */

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ex_10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("Party!")) {

            Predicate<String> predicate = getPredicate(input);

            String command = input[0];

            switch (command) {
                case "Double":
                    List<String> peopleToAddAgain = new ArrayList<>();
                    people.stream().filter(predicate).forEach(peopleToAddAgain::add);
                    people.addAll(peopleToAddAgain);
                    break;
                case "Remove":
                    people.removeIf(predicate);
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            String result = String.join(", ", people) + " are going to the party!";
            System.out.println(result);
        }


    }

    public static Predicate<String> getPredicate(String[] input) {

        Predicate<String> predicate = null;
        String filterName = input[1];
        String filterCriteria = input[2];

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }
        return predicate;
    }


}
