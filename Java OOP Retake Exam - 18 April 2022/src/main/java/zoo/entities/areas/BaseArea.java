package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;

public abstract class BaseArea implements Area {

    private String name;

    private int capacity;

    private Collection<Food> foods;

    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return 0;
    }

    @Override
    public void addAnimal(Animal animal) {

    }

    @Override
    public void removeAnimal(Animal animal) {

    }

    @Override
    public void addFood(Food food) {

    }

    @Override
    public void feed() {

    }

    @Override
    public String getInfo() {
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
