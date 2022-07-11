package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || "\\s+".equals(name) || name.length() < 4) {
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        }

        this.name = name;
    }

    private void setLaps(int laps) {

        if (laps < 1) {
            throw new IllegalArgumentException("Laps cannot be less than 1.");
        }

        this.laps = laps;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void addDriver(Driver driver) {

        //•	If a Driver is null throw an IllegalArgumentException with a message "Driver cannot be null.".

        if (null == driver) {
            throw new IllegalArgumentException("Driver cannot be null.");
        }

        //•	If a Driver cannot participate in the Race (the Driver doesn't own a Car)
        // throw an IllegalArgumentException with a message "Driver {driver name} could not participate in race.".
        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException("Driver " + driver.getName() + " could not participate in race.");
        }

        //•	If the Driver already exists in the Race throw an IllegalArgumentException with a message:
        //"Driver {driver name} is already added in {race name} race.".
        if (drivers.contains(driver)) {
            throw new IllegalArgumentException("Driver " + driver.getName() + " is already added in " + name + " race.");
        }

        drivers.add(driver);
    }
}
