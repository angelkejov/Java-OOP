package zoo.repositories;

import zoo.entities.foods.Food;

public class FoodRepositoryImpl implements FoodRepository {
    @Override
    public void add(Food food) {

    }

    @Override
    public boolean remove(Food food) {
        return false;
    }

    @Override
    public Food findByType(String type) {
        return null;
    }
}
