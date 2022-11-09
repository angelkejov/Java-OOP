package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.BaseBeverage;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFoods;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFoods = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.isReservedTable = false;
        this.allPeople = 0;
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return false;
    }

    @Override
    public double allPeople() {
        return 0;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (size >= numberOfPeople) {
            setNumberOfPeople(numberOfPeople);
            isReservedTable = true;
        }
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFoods.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverage) {
        beverages.add(beverage);
    }

    @Override
    public double bill() {
        double foods = healthyFoods.stream().mapToDouble(HealthyFood::getPrice).sum();
        double drinks = beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return foods + drinks + allPeople();
    }

    @Override
    public void clear() {
        beverages.clear();
        healthyFoods.clear();
        isReservedTable = false;
        setSize(size);
    }

    @Override
    public String tableInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        return
    }

    public abstract void orderHealthy();
}
