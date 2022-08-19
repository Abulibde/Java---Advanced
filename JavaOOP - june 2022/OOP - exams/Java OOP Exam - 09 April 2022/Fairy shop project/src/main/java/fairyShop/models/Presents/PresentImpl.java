package fairyShop.models.Presents;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    private void setName(String name) {
        if (null == name || name.equals("\\s+")) {
            throw new NullPointerException("Present name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException("Cannot create a Present requiring negative energy!");
        } else {
            this.energyRequired = energyRequired;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    @Override
    public boolean isDone() {
        return energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        energyRequired = Math.max(0, energyRequired - 10);
    }
}
