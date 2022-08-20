package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 9;
    private static final int STEP = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        upgradeKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        upgradeKilograms(STEP);
    }
}
