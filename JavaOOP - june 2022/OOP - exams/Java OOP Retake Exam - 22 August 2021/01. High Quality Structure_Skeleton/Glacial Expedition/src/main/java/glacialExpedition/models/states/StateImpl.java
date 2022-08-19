package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateImpl implements State {

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new IllegalArgumentException("Invalid name!");
        }

        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return name;
    }
}
