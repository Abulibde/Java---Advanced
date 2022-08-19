package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        // TODO: 10.8.2022 г. new suitcase
        suitcase = new Carton();
    }

    private void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new IllegalArgumentException("Explorer name cannot be null or empty.");
        }

        this.name = name;
    }

    private void setEnergy(double energy) {
        if (0 > energy) {
            throw new IllegalArgumentException("Cannot create Explorer with negative energy.");
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {

        return energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        double step = 15;
        decreaseEnergy(step);
    }

    protected void decreaseEnergy(double step) {
        energy = Math.max(0, energy - step);
    }

    public String getInfo(){
        //Name: {explorerName}
        //Energy: {explorerName}
        //Suitcase exhibits: {suitcaseExhibits1, suitcaseExhibits2, suitcaseExhibits3, …, suitcaseExhibits n}"

        String suitcaseExhibits = String.join(", ", getSuitcase().getExhibits());

        return String.format("Name: %s\n" +
                "Energy: %f\n" +
                "Suitcase exhibits: ",getName(),getEnergy(),suitcaseExhibits);
    }

}
