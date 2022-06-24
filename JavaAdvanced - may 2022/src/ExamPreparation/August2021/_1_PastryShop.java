package ExamPreparation.August2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        List<Integer> lineOfLiquids = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lineOfLiquids.forEach(liquidQueue::offer);


        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        List<Integer> lineOfIngredients = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lineOfIngredients.forEach(ingredients::push);


        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquidQueue.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquidQueue.pop();
            int ingredient = ingredients.poll();
            int sum = liquid + ingredient;

            if (sum == 25) {
                biscuit++;

            } else if (sum == 50) {
                cake++;

            } else if (sum == 75) {
                pastry++;

            } else if (sum == 100) {
                pie++;

            } else {
                ingredient += 3;
                ingredients.push(ingredient);
            }
        }

        String result;

        if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            result = String.format("Liquids left: %s", liquidQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(result);
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            result = String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(result);
        }

        System.out.printf("Biscuit: %d%n" +
                "Cake: %d%n" +
                "Pie: %d%n" +
                "Pastry: %d%n", biscuit, cake, pie, pastry);


    }
}
