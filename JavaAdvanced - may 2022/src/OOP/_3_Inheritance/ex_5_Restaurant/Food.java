package OOP._3_Inheritance.ex_5_Restaurant;

import java.math.BigDecimal;

public class Food extends Product {


  private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }
}
