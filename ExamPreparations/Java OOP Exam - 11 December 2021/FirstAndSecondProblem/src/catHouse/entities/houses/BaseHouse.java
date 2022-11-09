package catHouse.entities.houses;

import catHouse.entities.cat.BaseCat;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.CAT_NAME_NULL_OR_EMPTY;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sumSoftness = 0;
        for (Toy toy : toys) {
            sumSoftness += toy.getSoftness();
        }
        return sumSoftness;
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity > 0) {
            cats.add(cat);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        if (cats.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(this.name).append(" ").append(getClass().getSimpleName()).append(System.lineSeparator());
            sb.append(String.format("Cats: %s", cats.stream().map(Cat::getName).collect(Collectors.joining(" ")))).append(System.lineSeparator());
            sb.append(String.format("Toys: %s Softness: %s",toys.size(), toys.stream().map(Toy::getSoftness).mapToInt(Integer::intValue).sum()));
        }

        return sb.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return null;
    }

    @Override
    public Collection<Toy> getToys() {
        return null;
    }
}
