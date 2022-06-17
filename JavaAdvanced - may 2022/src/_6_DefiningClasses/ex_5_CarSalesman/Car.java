package _6_DefiningClasses.ex_5_CarSalesman;

import java.util.List;
import java.util.Map;

public class Car {
    //A Car has a model, engine, weight, and color

    private String carModel;
    private Map<String, List<Engine>> engine;
    private String weight;
    private String color;

    public Car(String carModel, Map<String, List<Engine>> engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight="n/a";
        this.color="n/a";
    }

    public Car(String carModel, Map<String, List<Engine>> engine, String weightOrColor) {
        this(carModel,engine);
        if (weightOrColor.matches("\\d+")){
            this.weight=weightOrColor;
        }else{
            this.color=weightOrColor;
        }
    }

    public Car(String carModel, Map<String, List<Engine>> engine, String weight, String color) {
        this(carModel,engine);
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public Map<String, List<Engine>> getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
