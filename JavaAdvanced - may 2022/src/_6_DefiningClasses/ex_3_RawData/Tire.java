package _6_DefiningClasses.ex_3_RawData;

public class Tire {
    private double pressure;
    private double age;

    public Tire(double pressure, double age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
