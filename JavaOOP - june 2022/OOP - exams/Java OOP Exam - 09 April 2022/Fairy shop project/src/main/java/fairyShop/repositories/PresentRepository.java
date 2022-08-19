package fairyShop.repositories;

import fairyShop.models.Presents.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present>{

    private Collection<Present> presents;

    public PresentRepository() {
        presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    @Override
    public void add(Present present) {
        presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        return presents.remove(present);
    }

    @Override
    public Present findByName(String name) {
        return presents.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }
}
