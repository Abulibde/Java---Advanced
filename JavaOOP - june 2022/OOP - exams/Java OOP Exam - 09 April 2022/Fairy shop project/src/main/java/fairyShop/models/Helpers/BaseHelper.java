package fairyShop.models.Helpers;

import fairyShop.models.Instruments.Instrument;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    private int energyForWork;

    public BaseHelper(String name, int energy) {
        setName(name);
        this.energy = energy;
        instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new NullPointerException("Helper name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }


    @Override
    public void work() {
        energy = Math.max(0, energy - energyForWork);
    }

    public void setEnergyForWork(int energyForWork) {
        this.energyForWork = energyForWork;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return energy > 0;
    }

    /*public void setEnergyForWork(int energyForWork) {
        this.energyForWork = energyForWork;
    }
     */

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public String getInfo() {
        //"Name: {helperName1}"
        //"Energy: {helperEnergy1}"
        //"Instruments: {countInstruments} not broken left"
        return  String.format("Name: %s\n" +
                "Energy: %d\n" +
                "Instruments: %d not broken left",name,energy,instruments.size()-getBrokenInstrument());

    }

    public long getBrokenInstrument() {
        return instruments.stream()
                .filter(Instrument::isBroken)
                .count();
    }
}
