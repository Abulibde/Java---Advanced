package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {

    private static final Car KIA = new Car("Kia", 240, 10);
    private static final Car RENAULT = new Car("Renault", 200, 100);
    private static final Car MITSUBISHI = new Car("Skoda", 300, 50);
    private static final Car SKODA = new Car("Skoda", 220, 3222221);

    private static final int EXPECTED_COUNT = 3;

    private static final int TEST_SPEED = 220;

    private Garage garage;

    @Before
    public void prepare() {
        garage = new Garage();

        garage.addCar(KIA);
        garage.addCar(RENAULT);
        garage.addCar(MITSUBISHI);

    }

    @Test
    public void testGetCars() {
        List<Car> realCars = garage.getCars();
        List<Car> testCars = new ArrayList<>();
        testCars.add(KIA);
        testCars.add(RENAULT);
        testCars.add(MITSUBISHI);

        Assert.assertArrayEquals(testCars.toArray(), realCars.toArray());
    }

    @Test
    public void testGetCount() {
        int realCount = garage.getCount();

        Assert.assertEquals(EXPECTED_COUNT, realCount);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        List<Car> realCars = garage.findAllCarsWithMaxSpeedAbove(TEST_SPEED);
        List<Car> testCars = new ArrayList<>();
        testCars.add(KIA);
        testCars.add(MITSUBISHI);

        Assert.assertArrayEquals(testCars.toArray(), realCars.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWithNullShouldThrow() {
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testAddCarSuccess() {
        garage.addCar(SKODA);
        Assert.assertEquals(EXPECTED_COUNT + 1, garage.getCount());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        garage.addCar(SKODA);
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        Assert.assertEquals(SKODA, theMostExpensiveCar);
    }

    @Test
    public void testFindAllCarsByBrand() {
        garage.addCar(SKODA);
        List<Car> carsByBrand = garage.findAllCarsByBrand("Skoda");
        List<Car> testCars = new ArrayList<>();
        testCars.add(MITSUBISHI);
        testCars.add(SKODA);

        Assert.assertArrayEquals(testCars.toArray(), carsByBrand.toArray());
        Assert.assertEquals(2, carsByBrand.size());

    }

}