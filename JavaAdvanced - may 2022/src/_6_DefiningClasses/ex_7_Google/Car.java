package _6_DefiningClasses.ex_7_Google;

public class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarSpeed() {
        return carSpeed;
    }
}
