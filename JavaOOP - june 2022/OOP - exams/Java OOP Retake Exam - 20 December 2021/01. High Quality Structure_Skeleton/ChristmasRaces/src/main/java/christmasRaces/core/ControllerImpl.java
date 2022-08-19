package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.IllformedLocaleException;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {

        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException("Driver " + driver + " is already created.");
        }

        Driver newDriver = new DriverImpl(driver);
        driverRepository.add(newDriver);

        return String.format("Driver %s is created.", driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        Car car = null;

        if (null != carRepository.getByName(model)) {
            throw new IllegalArgumentException("Car " + model + " is already created.");
        }

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        carRepository.add(car);
        assert car != null;
        String carType = car.getClass().getSimpleName();
        return carType + " " + model + " is created.";
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException("Driver " + driverName + " could not be found.");
        }

        Car car = carRepository.getByName(carModel);

        if (car == null) {
            throw new IllegalArgumentException("Car " + carModel + " could not be found.");
        }

        driver.addCar(car);

        return "Driver " + driverName + " received car " + carModel + ".";
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException("Race " + raceName + " could not be found.");
        }

        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException("Driver " + driverName + " could not be found.");
        }

        race.addDriver(driver);

        return "Driver " + driverName + " added in " + raceName + " race.";
    }

    @Override
    public String startRace(String raceName) {

        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        }

        if (race.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3) {
            throw new IllegalArgumentException(String.format("Race %s cannot start with less than 3 participants.", raceName));
        }

        List<Driver> sortedDriver = race.getDrivers().stream().
                sorted((s1, s2) -> Double.compare(s2.getCar().calculateRacePoints(race.getLaps()), s1.getCar().calculateRacePoints(race.getLaps()))).
                collect(Collectors.toList());

        return String.format("Driver %s wins %s race.", sortedDriver.get(0).getName(), raceName) + System.lineSeparator() +
                String.format("Driver %s is second in %s race.", sortedDriver.get(1).getName(), raceName) + System.lineSeparator() +
                String.format("Driver %s is third in %s race.", sortedDriver.get(2).getName(), raceName);
    }



    @Override
    public String createRace(String name, int laps) {

        Race raceFind = raceRepository.getByName(name);
        if (raceFind != null) {
            throw new IllegalArgumentException("Race " + name + " is already created.");
        }

        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);


        return "Race " + name + " is created.";
    }
}
