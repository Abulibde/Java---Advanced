package OOP._3_Inheritance.ex_4_NeedForSpeed;

public class SportCar extends Car {

    final static double DEFAULT_FUEL_CONSUMPTION = 10
            ;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
