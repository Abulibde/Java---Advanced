package ExamPreparation.April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        List<Integer> listOfSteel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        listOfSteel.forEach(steelQueue::offer);

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        List<Integer> listOfCarbon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        listOfCarbon.forEach(carbonStack::push);

        //o	"Sabre: {amount}"
        //o	"Katana: {amount}"
        //o	"Shamshir: {amount}"
        //o	"Gladius: {amount}"
        int totalNumOfSwords = 0;
        int gladius = 0;
        int katana = 0;
        int shamshir = 0;
        int sabre = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int carbon = carbonStack.pop();
            int sum = carbon + steelQueue.poll();

            if (sum == 70) {
                gladius++;
                totalNumOfSwords++;

            } else if (sum == 80) {
                shamshir++;
                totalNumOfSwords++;

            } else if (sum == 90) {
                katana++;
                totalNumOfSwords++;

            } else if (sum == 110) {
                sabre++;
                totalNumOfSwords++;

            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        String result;

        if (totalNumOfSwords > 0) {
            System.out.println("You have forged " + totalNumOfSwords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            result = String.format("Steel left: %s", steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(result);
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            result = String.format("Carbon left: %s", carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(result);
        }

        if (gladius > 0) {
            System.out.println("Gladius: " + gladius);
        }
        if (katana > 0) {
            System.out.println("Katana: " + katana);
        }
        if (shamshir > 0) {
            System.out.println("Shamshir: " + shamshir);
        }
        if (sabre > 0) {
            System.out.println("Sabre: " + sabre);
        }

       /*Set<String> set = new TreeSet<>();
        set.add("gladius");
        set.add("katana");
        set.add("shamshir");
        set.add("sobre");

        System.out.println();

        */


    }
}
