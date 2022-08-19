package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        numberOfWins = 0;
        canParticipate = false;
    }

    private void setName(String name) {
        if (null == name || "\\s+".equals(name) || name.length() < 4) {
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        }

        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {

        if (null == car) {
            throw new IllegalArgumentException("Car cannot be null.");
        }

        this.car = car;
        canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
