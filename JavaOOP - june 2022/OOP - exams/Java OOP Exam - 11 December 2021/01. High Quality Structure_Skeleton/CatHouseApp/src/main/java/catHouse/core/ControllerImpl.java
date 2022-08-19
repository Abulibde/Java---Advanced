package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;
import jdk.dynalink.support.ChainedCallSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }


    @Override
    public String addHouse(String type, String name) {
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid house type.");
        }
        houses.add(house);

        return type + " is successfully added.";
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException("Invalid toy type.");
        }

        toys.buyToy(toy);

        return type + " is successfully added.";
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {

        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException("Toy of type " + toyType + " is missing.");
        }

        House house = getHouse(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);

        return "Successfully added " + toyType + " to " + houseName + ".";
    }

    private House getHouse(String houseName) {
        return houses.stream().filter(s -> s.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat = null;
        House house = getHouse(houseName);

        boolean success = false;

        switch (catType) {

            case "ShorthairCat":

                if (house.getClass().getSimpleName().equals("ShortHouse")) {
                    cat = new ShorthairCat(catName, catBreed, price);
                    house.addCat(cat);
                    success = true;
                }
                break;

            case "LonghairCat":

                if (house.getClass().getSimpleName().equals("LongHouse")) {
                    cat = new LonghairCat(catName, catBreed, price);
                    house.addCat(cat);
                    success = true;
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid house type.");
        }

        return success ?
                "Successfully added " + catType + " to " + houseName + "."
                : "Unsuitable house.";
    }

    @Override
    public String feedingCat(String houseName) {

        House house = getHouse(houseName);

        Collection<Cat> cats = house.getCats();

        cats.forEach(Cat::eating);

        return "Feeding a cat: " + cats.size();
    }

    @Override
    public String sumOfAll(String houseName) {

        House house = getHouse(houseName);

        Collection<Cat> cats = house.getCats();

        Collection<Toy> toys = house.getToys();

        double catsPrice = cats.stream().mapToDouble(Cat::getPrice).sum();
        double toysPrice = toys.stream().mapToDouble(Toy::getPrice).sum();
        double totalPrice = catsPrice + toysPrice;

        return String.format("The value of House %s is %.2f.", houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining("\n"));
    }
}
