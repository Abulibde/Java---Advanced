package TheRealExam;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        List<Double> lineOfMilk = new ArrayList<>();
        for (String s : scanner.nextLine().split(" ")) {
            Double parseDouble = Double.parseDouble(s);
            lineOfMilk.add(parseDouble);
        }

        lineOfMilk.forEach(milkQueue::offer);


        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        List<Double> lineOfCacao = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        lineOfCacao.forEach(cacaoStack::push);

        Map<String, Integer> chocolateTypes = new TreeMap<>();
        chocolateTypes.put("Milk Chocolate", 0);
        chocolateTypes.put("Dark Chocolate", 0);
        chocolateTypes.put("Baking Chocolate", 0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.pop();
            double cacao = cacaoStack.poll();

            double sum = milk + cacao;
            double cacaoPercentage = Math.round(cacao / sum * 100);

            if (cacaoPercentage == 30.0) {
                chocolateTypes.put("Milk Chocolate", chocolateTypes.get("Milk Chocolate") + 1);

            } else if (cacaoPercentage == 50.0) {
                chocolateTypes.put("Dark Chocolate", chocolateTypes.get("Dark Chocolate") + 1);

            } else if (cacaoPercentage == 100.0) {
                chocolateTypes.put("Baking Chocolate", chocolateTypes.get("Baking Chocolate") + 1);

            } else {
                milk += 10;
                milkQueue.offer(milk);
            }
        }

        String result;

        if (chocolateTypes.get("Milk Chocolate") > 0 &&
                chocolateTypes.get("Dark Chocolate") > 0 && chocolateTypes.get("Baking Chocolate") > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolateTypes.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("# %s --> %d%n", key, value);
            }
        });
    }
}

