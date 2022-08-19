package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HouseTests {


    private static final String FIRST_HOUSE_NAME = "LongHouse";
    private static final String SECOND_HOUSE_NAME = "ShortHouse";
    private static final String NULL_HOUSE_NAME = null;
    private static final String EMPTY_HOUSE_NAME = "";
    private static final String WHITESPACE_HOUSE_NAME = " ";

    private static final int ONE_CAPACITY = 1;
    private static final int TWO_CAPACITY = 2;
    private static final int HUNDRED_CAPACITY = 100;
    private static final int ZERO_CAPACITY = 0;
    private static final int NEGATIVE_CAPACITY = -12;

    private static final Cat ONE = new Cat("Paco");
    private static final Cat TWO = new Cat("Boncho");
    private static final Cat THREE = new Cat("Fifi");
    private static final Cat FIVE = new Cat("Matsa");
    private static final Cat NULL_CAT = null;

    private ArrayList<Cat> test_cats = new ArrayList<>();

    private House house;

    @Before
    public void Setup() {
        house = new House(FIRST_HOUSE_NAME, TWO_CAPACITY);
        house.addCat(ONE);
        ArrayList<Cat> test_cats = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithNullName() {
        house = new House(NULL_HOUSE_NAME, HUNDRED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithWhitespaceName() {
        house = new House(WHITESPACE_HOUSE_NAME, HUNDRED_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithNegativeCapacityShouldThrow() {
        house = new House(FIRST_HOUSE_NAME, NEGATIVE_CAPACITY);
    }

    @Test
    public void testCreateHouseWithZeroCapacity() {
        house = new House(FIRST_HOUSE_NAME, ZERO_CAPACITY);
        Assert.assertEquals(ZERO_CAPACITY, house.getCapacity());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(FIRST_HOUSE_NAME, house.getName());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWithoutCapacityShouldThrow() {
        house.addCat(TWO);
        house.addCat(THREE);
    }

    @Test
    public void testAddCatSuccess() {
        house.addCat(THREE);

        test_cats.add(ONE);
        test_cats.add(THREE);

        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatWithNullCatShouldThrow() {
        house.removeCat("null");
    }

    @Test
    public void testRemoveCatSuccess() {
        house.removeCat("Paco");

        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWithNullCatShouldThrow() {
        house.catForSale("null");
    }

    @Test
    public void testCatForSaleSuccess() {
        boolean result = house.catForSale("Paco").isHungry();

        Assert.assertFalse(result);
    }


    @Test
    public void testStatistics() {
        house.addCat(TWO);
        String expectedOutput = "The cat Paco, Boncho is in the house LongHouse!";

        String output = house.statistics();

        Assert.assertEquals(expectedOutput, output);
    }

}
