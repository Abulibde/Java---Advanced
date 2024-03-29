package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    Collection<Race> models;

    public RaceRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return models.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Race model) {
        models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return false;
    }
}
