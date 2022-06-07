package OOP._3_Inheritance.ex_4_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{

    final static double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
