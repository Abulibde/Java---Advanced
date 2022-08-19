package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class DriverRepository implements Repository<Driver> {

    Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }


    @Override
    public Driver getByName(String name) {
        return models.stream().filter(driver -> driver.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return models;
    }

    @Override
    public void add(Driver model) {
        models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return models.remove(model);
    }


}
