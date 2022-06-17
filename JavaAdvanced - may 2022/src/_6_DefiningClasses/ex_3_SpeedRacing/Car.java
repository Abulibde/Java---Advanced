package _6_DefiningClasses.ex_3_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumption;
    private int distance;


    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean hasEnoughFuel(int kilometers) {
        double fuelNeeded = handleNeededFuel(kilometers);
        return fuelAmount >= fuelNeeded;
    }

    public void drive(int kilometers) {
        double fuelNeeded = handleNeededFuel(kilometers);
        this.fuelAmount -= fuelNeeded;
        this.distance += kilometers;
    }

    public double handleNeededFuel(int kilometers) {
        return kilometers * consumption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
