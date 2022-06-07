package OOP._3_Inheritance.ex_4_NeedForSpeed;

public class Car extends Vehicle{

    final static double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
