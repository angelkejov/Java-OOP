package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {
    private List<Player> models;

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        for (Player model : models) {
            if (model.getUsername().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
