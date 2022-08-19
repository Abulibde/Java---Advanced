package fairyShop.models.Helpers;

public class Sleepy extends BaseHelper{
    private static final int ENERGY_FOR_WORK = 15;

    public Sleepy(String name) {
        super(name,50);
        setEnergyForWork(ENERGY_FOR_WORK);
    }

    @Override
    public void setEnergyForWork(int energyForWork) {
        super.setEnergyForWork(energyForWork);
    }
}
