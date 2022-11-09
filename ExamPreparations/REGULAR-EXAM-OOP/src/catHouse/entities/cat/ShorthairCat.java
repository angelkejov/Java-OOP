package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static int INITIAL_KILOGRAMS = 7;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }
    @Override
    public void eating() {
        INITIAL_KILOGRAMS += 1;
    }
}
