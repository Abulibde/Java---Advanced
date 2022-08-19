package christmasRaces.entities.cars;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    //o	If the model is null, whitespace, or less than 4 symbols,
    // throw an IllegalArgumentException with a message
    // "Model {model} cannot be less than 4 symbols."

    private void setModel(String model) {
        if (null == model || "\\s+".equals(model) || model.length() < 4) {
            throw new IllegalArgumentException(String.format("Model %s cannot be less than 4 symbols.", model));
        }

        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (("MuscleCar".equals(getClass().getSimpleName()) && (horsePower < 400 || 600 < horsePower)) ||
                ("SportsCar".equals(getClass().getSimpleName()) && (horsePower < 250 || 450 < horsePower))) {
            throw new IllegalArgumentException(String.format("Invalid horse power: %d.", horsePower));
        }

        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}
