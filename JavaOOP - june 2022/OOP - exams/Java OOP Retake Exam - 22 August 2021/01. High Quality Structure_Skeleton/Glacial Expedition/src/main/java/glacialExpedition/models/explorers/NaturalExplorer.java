package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double INITIAL_ENERGY = 60;
    private static final double DECREASING_STEP = 7;


    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        decreaseEnergy(DECREASING_STEP);
    }
}
