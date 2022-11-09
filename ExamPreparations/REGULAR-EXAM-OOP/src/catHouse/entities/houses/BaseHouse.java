package catHouse.entities.houses;

import catHouse.entities.cat.BaseCat;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : toys) {
            sum += toy.getSoftness();
        }
        return sum;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" ")
                .append(this.getClass().getSimpleName()).append(":")
                .append(System.lineSeparator());

        stringBuilder.append("Cats:");
        if (cats.isEmpty()) {
            stringBuilder.append(" none");
        } else {
            for (Cat cat : cats) {
                stringBuilder.append(" ").append(cat.getName());
            }
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Toys: ").append(toys.size())
                .append(" Softness: ").append(this.sumSoftness());

        return stringBuilder.toString().trim();
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
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
