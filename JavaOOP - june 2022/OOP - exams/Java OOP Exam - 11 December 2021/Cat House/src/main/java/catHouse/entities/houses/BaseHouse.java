package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }


    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {

        if (getCapacityLeft() < 1) {
            throw new IllegalArgumentException("Not enough capacity for this cat.");
        }

        cats.add(cat);
    }

    public int getCapacityLeft() {
        return capacity - cats.size();
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {

        return name + " " + getClass().getSimpleName() + ":" + System.lineSeparator() +
                "Cats: " + (cats.size() == 0 ? "none" : cats.stream().map(Cat::getName).collect(Collectors.joining(" "))) + System.lineSeparator() +
                "Toys: " + toys.size() + " Softness: " + sumSoftness();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new IllegalArgumentException("House name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(toys);
    }
}
