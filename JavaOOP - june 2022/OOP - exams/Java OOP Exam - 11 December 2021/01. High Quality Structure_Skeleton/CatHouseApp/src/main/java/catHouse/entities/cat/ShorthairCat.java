package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 7;
    private static final int STEP = 1;


    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        upgradeKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        upgradeKilograms(STEP);
    }
}
