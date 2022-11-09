package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private List<HealthyFood> healthyFoods;

    public HealthFoodRepositoryImpl() {
        this.healthyFoods = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return null;
    }

    @Override
    public void add(HealthyFood entity) {

    }
}
