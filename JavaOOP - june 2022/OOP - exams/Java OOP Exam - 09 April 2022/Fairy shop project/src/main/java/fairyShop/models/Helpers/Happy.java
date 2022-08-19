package fairyShop.models.Helpers;

public class Happy extends BaseHelper{

    private static final int ENERGY_FOR_WORK = 10;

    public Happy(String name) {
        super(name,100);
        setEnergyForWork(ENERGY_FOR_WORK);
    }

    @Override
    public void setEnergyForWork(int energyForWork) {
        super.setEnergyForWork(energyForWork);
    }
}
