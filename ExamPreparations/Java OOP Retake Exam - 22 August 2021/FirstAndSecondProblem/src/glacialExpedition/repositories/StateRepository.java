package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;

public class StateRepository implements Repository<State> {
    private Map<String, State> states;

    public StateRepository() {
        states = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states.values());
    }

    @Override
    public void add(State entity) {
        states.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(State entity) {
        return states.remove(entity.getName(), entity);
    }

    @Override
    public State byName(String name) {
        return states.get(name);
    }
}
