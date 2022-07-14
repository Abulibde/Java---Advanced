package OOP._3_Inheritance.ex_5_Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {

    private final static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
