package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {
    Garage garage;
    Car car;

    @Before
    public void setUp() {
        car = new Car("audi", 200, 20000.00);
        garage =  new Garage();
        garage.addCar(car);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsUnmodifiedListThrowsExceptionWhenTryingToChange(){
        garage.getCars().clear();
    }

    @Test
    public void testGetCountReturnsTheSizeOfTheGarage(){
        Assert.assertEquals(1, garage.getCount());
    }
    @Test
    public void testMaxSpeedCars(){
        Car car1 = new Car("bmw", 150, 10000);
        List<Car> maxCar = new ArrayList();
        maxCar.add(car);
        garage.addCar(car1);
        Assert.assertEquals(maxCar, garage.findAllCarsWithMaxSpeedAbove(170));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowsExceptionWhenCarIsNull(){
        garage.addCar(null);
    }
    @Test
    public void testAddCarWorksFine(){
        garage.addCar(new Car("volga", 100, 1000));
        Assert.assertEquals(2, garage.getCount());
        String carInGarage = car.getBrand();
        String brand = garage.getCars().get(0).getBrand();
        Assert.assertEquals(carInGarage, brand);
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        Assert.assertEquals(1, garage.getCount());
        Car mostExpensive = garage.getTheMostExpensiveCar();
        garage.addCar(new Car("moskvich", 100, 5000));
        Assert.assertEquals("audi", mostExpensive.getBrand());
        Assert.assertEquals(mostExpensive, car);
    }
    @Test
    public void testGetMOstExpensiveCarReturnsNull(){
        Garage garage1 = new Garage();

        Assert.assertNull(garage1.getTheMostExpensiveCar());
    }
    @Test
    public void testAllCarsByBrandWorksFine(){
        List<Car> carsAudi = new ArrayList<>();
        carsAudi.add(car);
        Car carA = new Car("audi", 100, 100001);
        garage.addCar(carA);
        carsAudi.add(carA);
        Assert.assertEquals(carsAudi, garage.findAllCarsByBrand("audi"));
    }

    @Test
    public void testFindAllCarsWithSpeedAbove() {
        Garage garage = new Garage();
        Car car = new Car("kur", 300, 1500.99);
        int speed = 100;
        garage.addCar(car);
        Assert.assertEquals(car, garage.findAllCarsWithMaxSpeedAbove(speed));
    }
}