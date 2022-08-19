package fairyShop.repositories;

import fairyShop.models.Helpers.BaseHelper;
import fairyShop.models.Helpers.Helper;
import fairyShop.models.Presents.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<BaseHelper> {

    private Collection<BaseHelper> helpers;

    public HelperRepository() {
        helpers = new ArrayList<>();
    }

    @Override
    public Collection<BaseHelper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(BaseHelper helper) {
        helpers.add(helper);
    }

    @Override
    public boolean remove(BaseHelper helper) {
        return helpers.remove(helper);
    }

    @Override
    public BaseHelper findByName(String name) {
        return helpers.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }


}
