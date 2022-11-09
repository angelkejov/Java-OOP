package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipTests {
    List<Spaceship> spaceships;

    @Before
    public void prepare() {
        spaceships = new ArrayList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityThrowExceptionWhenBelowZero() {
        Spaceship spaceship = new Spaceship("test", -1);
    }

    @Test
    public void testNameThrowExceptionWhenNull() {
        Spaceship spaceship = new Spaceship(null, 0);
    }

    @Test
    public void test() {
        Astronaut astronaut = new Astronaut("Pesho", 10);
        String name = "Pesho";
        Assert.assertEquals(name, astronaut.getName());
    }
}
