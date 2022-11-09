package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        for (Gun model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
