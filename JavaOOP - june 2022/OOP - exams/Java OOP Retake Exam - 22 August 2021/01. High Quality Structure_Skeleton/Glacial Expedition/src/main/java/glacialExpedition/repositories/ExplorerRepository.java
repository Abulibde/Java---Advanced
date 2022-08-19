package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExplorerRepository implements Repository<Explorer> {

    private Collection<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }


    @Override
    public Collection<Explorer> getCollection() {
        return explorers;
    }

    @Override
    public void add(Explorer entity) {
        explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return explorers.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getInfo() {
        //Name: {explorerName}
        //Energy: {explorerName}
        //Suitcase exhibits: {suitcaseExhibits1, suitcaseExhibits2, suitcaseExhibits3, …, suitcaseExhibits n}"

        Collection<Explorer> explorers = getCollection();
        StringBuilder sb = new StringBuilder();
        for (Explorer explorer : explorers) {
            sb.append(String.format("Name: %s\n" +
                    "Energy: %f\n" +
                    "Suitcase exhibits: %s\n", explorer.getName(), explorer.getEnergy(), String.join(", ", explorer.getSuitcase().getExhibits())));
        }

        return sb.toString().trim();
    }
}


