package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class HouseTests {
    private House house;
    private Cat cat;
    private Cat cat1;
    private Cat cat2;

    @Before
    public void prepare() {
        this.house = new House("test", 5);
        this.cat = new Cat("LepaBrena");
        this.cat1 = new Cat("Mile");
        this.cat2 = new Cat("dinko");
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull() {
        House house = new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsEmpty() {
        House house = new House("    ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        House house = new House("burkotiq", -1);
    }

    @Test
    public void testGetCatsCountShouldReturnTwo() {
        house.addCat(cat);
        house.addCat(cat1);

        assertEquals(2, house.getCount());
    }

    @Test
    public void testGetCatsCountShouldReturnZeroWhenEmpty() {
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatIfIsNotInTheHouseShouldFail() {
        house.addCat(cat);
        house.removeCat("mile");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCatExistsShouldFail() {
        house.addCat(cat);
        house.catForSale("Mile");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameCatShouldFail() {
        House nekvavilla = new House("nekvavilla", 2);
        nekvavilla.addCat(cat);
        nekvavilla.addCat(cat1);
        nekvavilla.addCat(cat2);
    }

    @Test
    public void testHouseCapacity() {
        House kushta = new House("kushta", 2);
        kushta.addCat(cat1);
        kushta.addCat(cat2);

        assertEquals(2, kushta.getCapacity());
    }

    @Test
    public void testGetCatStatistics () {
        house.addCat(cat);
        house.addCat(cat1);
        house.addCat(cat2);
        house.statistics();
    }

    @Test
    public void test19() {
        House house = new House("kushtata na geleto", 3);
        Cat cat = new Cat("lubcho");
        house.addCat(cat);
        Assert.assertEquals(house.getCapacity(), 3);
        house.removeCat(cat.getName());
        Assert.assertEquals(house.getCapacity(), 2);
    }
}
