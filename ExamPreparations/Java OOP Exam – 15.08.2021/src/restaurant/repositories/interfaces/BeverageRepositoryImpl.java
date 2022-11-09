package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    Collection<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return null;
    }

    @Override
    public void add(Beverages entity) {

    }
}
