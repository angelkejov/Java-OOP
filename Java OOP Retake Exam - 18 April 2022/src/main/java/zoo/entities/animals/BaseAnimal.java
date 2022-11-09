package zoo.entities.animals;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {

    private String name;

    private String kind;

    private double kg;

    private double price;

    public BaseAnimal(String name, String kind, double kg, double price) {
        this.name = name;
        this.kind = kind;
        this.kg = kg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException(ANIMAL_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        if (kind == null || kind.isEmpty()) {
            throw new NullPointerException(ANIMAL_KIND_NULL_OR_EMPTY);
        }

        this.kind = kind;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) throws IllegalAccessException {
        if (price < 0) {
            throw new IllegalAccessException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }

        this.price = price;
    }
}
