package fairyShop.core;

import fairyShop.models.Helpers.BaseHelper;
import fairyShop.models.Helpers.Happy;
import fairyShop.models.Helpers.Helper;
import fairyShop.models.Helpers.Sleepy;
import fairyShop.models.Instruments.Instrument;
import fairyShop.models.Instruments.InstrumentImpl;
import fairyShop.models.Presents.Present;
import fairyShop.models.Presents.PresentImpl;
import fairyShop.models.Shop.Shop;
import fairyShop.models.Shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
    }


    @Override
    public String addHelper(String type, String helperName) {

        BaseHelper helper;

        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException("Helper type doesn't exist!");
        }

        helperRepository.add(helper);

        return String.format("Successfully added %s named %s!", type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        BaseHelper helper = helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException("The helper you want to add an instrument to doesn't exist!");
        }

        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format("Successfully added instrument with power %s to helper %s!", power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format("Successfully added Present: %s!", presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        BaseHelper helper = helperRepository.getModels().stream().filter(s -> s.getEnergy() > 50).findFirst().orElse(null);

        if (helper == null) {
            throw new IllegalArgumentException("There is no helper ready to start crafting!");
        }

        Present present = presentRepository.findByName(presentName);

        Shop shop = new ShopImpl();
        shop.craft(present, helper);

        String isPresentDone = present.isDone() ? "done" : "not done";

        return String.format("Present %s is %s. %s instrument/s have been broken while working on it!"
                , presentName, isPresentDone, helper.getBrokenInstrument());
    }

    @Override
    public String report() {
        return presentRepository.getModels().stream().filter(Present::isDone).count() + " presents are done!" + System.lineSeparator() +
                "Helpers info:" + ((helperRepository.getModels().size() == 0) ? "" : System.lineSeparator() +
                helperRepository.getModels().stream().map(BaseHelper::getInfo).collect(Collectors.joining(System.lineSeparator())));
        //"{countCraftedPresents} presents are done!"
        //"Helpers info:"
        //"Name: {helperName1}"
        //"Energy: {helperEnergy1}"
        //"Instruments: {countInstruments} not broken left"
        //…
        //"Name: {helperNameN}"
        //"Energy: {helperEnergyN}"
        //"Instruments: {countInstruments} not broken left";
    }
}
