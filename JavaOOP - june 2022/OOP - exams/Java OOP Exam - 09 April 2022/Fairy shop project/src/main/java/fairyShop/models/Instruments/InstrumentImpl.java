package fairyShop.models.Instruments;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Cannot create an Instrument with negative power!");
        } else {
            this.power = power;
        }
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        power = Math.max(0, power - 10);
    }

    @Override
    public boolean isBroken() {
        return power == 0;
    }
}
