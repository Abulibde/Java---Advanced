package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTests {

    private final static int ANIMALS_COUNT = 5;
    private final static int ANIMALS_MAX_KILOGRAMS_TO_FIND = 100;
    private final static String ANIMALS_TO_FIND_BY_SPECIE = "water";


    private PetStore petStore;

    private static final Animal one = new Animal("water", 15, 120.20);
    private static final Animal two = new Animal("water", 1, 10.20);
    private static final Animal tree = new Animal("water", 150, 150.20);
    private static final Animal four = new Animal("space", 400, 1250.20);
    private static final Animal five = new Animal("space", 12, 9990.20);

    @Before
    public void prepare() {
        petStore = new PetStore();

        petStore.addAnimal(one);
        petStore.addAnimal(tree);
        petStore.addAnimal(two);
        petStore.addAnimal(four);
        petStore.addAnimal(five);

    }

    @Test
    public void testGetAnimals() {
        ArrayList<Animal> expected = new ArrayList<>();
        expected.add(one);
        expected.add(tree);
        expected.add(two);
        expected.add(four);
        expected.add(five);

        List<Animal> actual = petStore.getAnimals();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void animalCountInPetStore() {
        Assert.assertEquals(ANIMALS_COUNT, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrow() {
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void findAllAnimalsWithMaxKilograms() {

        List<Animal> expected = new ArrayList<>();
        expected.add(tree);
        expected.add(four);

        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(ANIMALS_MAX_KILOGRAMS_TO_FIND);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTheMostExpensiveAnimal() {
        Assert.assertEquals(five, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void findAllAnimalBySpecieWater() {
        List<Animal> expected = new ArrayList<>();
        expected.add(one);
        expected.add(tree);
        expected.add(two);

        List<Animal> actual = petStore.findAllAnimalBySpecie(ANIMALS_TO_FIND_BY_SPECIE);

        Assert.assertEquals(expected, actual);
    }

}

