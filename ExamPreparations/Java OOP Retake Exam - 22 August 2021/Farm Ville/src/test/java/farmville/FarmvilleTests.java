package farmville;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmvilleTests {
    Farm farm;
    List<Animal> animals;

    @Before
    public void prepare() {
        farm = new Farm("test_name", 10);
        animals = new ArrayList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityShouldThrowExceptionWhenCapacityIsBelowZero() {
        farm = new Farm("test_name", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowsExceptionWhenItIsNull() {
        farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowsExceptionWhenItIsEmpty() {
        farm = new Farm("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionWhenIsFull() {
        for (Animal animal : animals) {
            farm.add(animal);
        }
        farm.add(new Animal("test_type", 2.2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionWhenAnimalExist() {
        Animal animal = new Animal("test_type", 5.50);
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testRemoveSuccessfully() {
        Animal animal = new Animal("test_type", 5.50);
        farm.add(animal);
        farm.remove(animal.getType());
    }

    @Test
    public void testRemoveUnSuccessful() {
        Animal animal = new Animal("test_type", 5.50);
        farm.add(animal);
        farm.remove("error_type");
    }
}
