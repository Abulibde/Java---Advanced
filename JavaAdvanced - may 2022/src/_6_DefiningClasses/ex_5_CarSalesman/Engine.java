package _6_DefiningClasses.ex_5_CarSalesman;

public class Engine {

    //model, power, displacement, and efficiency.

    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, String power, String disEFF) {
        this(engineModel, power);
        if (disEFF.matches("\\d+")) {
            this.displacement = disEFF;
        } else {
            this.efficiency = disEFF;
        }
    }

    public Engine(String engineModel, String power, String displacement, String efficiency) {
        this(engineModel,power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
