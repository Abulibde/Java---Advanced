package easterBasket;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    //•	Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    //•	Method removeEgg(string color) – removes an egg by given color,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeEgg(String color) {
        return data.removeIf(p -> p.getColor().equals(color));
    }

    //Method getStrongestEgg()– returns the strongest egg
    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    //•	Method getEgg(string color) – returns the egg with the given color
    public Egg getEgg(String color) {
        return data.stream().
                filter(egg -> egg.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    //•	Method getCount – returns the number of eggs
    public int getCount() {
        return data.size();
    }

    //•	Method report() – returns a string in the following format (print the eggs in order of appearance):
    //o	"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", this.material));

        for (Egg egg : data) {
            sb.append(String.format("%s%n", egg.toString()));
        }
        return sb.toString();
    }
}
