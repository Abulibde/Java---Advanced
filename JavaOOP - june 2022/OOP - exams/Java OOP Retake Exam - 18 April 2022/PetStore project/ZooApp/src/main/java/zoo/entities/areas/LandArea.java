package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.animals.TerrestrialAnimal;

public class LandArea extends BaseArea{

    private static final int CAPACITY = 25;

    public LandArea(String name) {
        super(name, CAPACITY);
    }

    public void addAnimal(Animal animal) {

        if (animal instanceof TerrestrialAnimal) {
            super.addAnimal(animal);
        }
    }
}
