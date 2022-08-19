package fairyShop.models.Shop;

import fairyShop.models.Helpers.Helper;
import fairyShop.models.Instruments.Instrument;
import fairyShop.models.Presents.Present;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {


        //If at some point the power of the current instrument reaches or drops below 0,
        // meaning it is broken, then the helper should take the next instrument from its collection,
        // if it has any left.
        for (Instrument instrument : helper.getInstruments()) {
            //The helper starts crafting:
            // helper has energy and an instrument that isn't broken.
            while (!instrument.isBroken()) {
                //Keep working until the present is done
                // or the helper has energy (and instruments to use).
                helper.work();
                instrument.use();
                present.getCrafted();

                if (present.isDone() || !helper.canWork()) return;
            }

        }
    }
}
