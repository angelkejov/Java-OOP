package com.company.Lab.Animals;

public class Dog extends Animal{
    private String name;
    private String favouriteFood;

    public Dog(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s DJAAF", this.name, this.favouriteFood);
    }
}
