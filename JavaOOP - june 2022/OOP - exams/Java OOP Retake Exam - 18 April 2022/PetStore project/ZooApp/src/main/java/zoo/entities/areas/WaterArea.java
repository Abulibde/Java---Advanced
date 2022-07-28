package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.foods.Food;

import java.util.Collection;

public class WaterArea extends BaseArea {

    private static final int CAPACITY = 10;

    public WaterArea(String name) {
        super(name, CAPACITY);
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof AquaticAnimal) {
            super.addAnimal(animal);
        }
    }
}
