package catHouse.repositories;

import catHouse.entities.toys.Ball;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;

import java.util.Collection;
import java.util.List;

public class ToyRepository implements Repository {
    private List<Toy> toyCollection;

    @Override
    public void buyToy(Toy toy) {
        toyCollection.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return toyCollection.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        for (Toy toy : toyCollection) {
            if (type.equals(Ball.class.getTypeName())) {
                return toy;
            } else if (type.equals(Mouse.class.getTypeName())) {
                return toy;
            }
        }
        return null;
    }
}
