package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.houses.BaseHouse;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository toyRepository;
    private List<House> houseCollection;

    public ControllerImpl() {
        toyRepository = new ToyRepository();
        houseCollection = new ArrayList<>();
    }


    @Override
    public String addHouse(String type, String name) {
        switch (type) {
            case "ShortHouse":
                House house = new ShortHouse(name);
                this.houseCollection.add(house);
                break;

            case "LongHouse":
                House house1 = new LongHouse(name);
                this.houseCollection.add(house1);
                break;

            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        switch (type) {
            case "Ball":
                Toy toy = new Ball();
                toyRepository.buyToy(toy);
                break;

            case "Mouse":
                Toy toy1 = new Mouse();
                toyRepository.buyToy(toy1);
                break;

            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        if (toyType.equals("Ball") || toyType.equals("Mouse")) {
            buyToy(toyType);
            Toy toyToRemoved = toyRepository.findFirst(toyType);
            toyRepository.removeToy(toyToRemoved);
        } else {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        if (catType.equals("LonghairCat") ||catType.equals("ShorthairCat")) {
            switch (catType) {
                case "LonghairCat":
                    if (houseCollection.getClass().getSimpleName().equals("LongHouse")) {
                        addCat(houseName, catType, catName, catBreed, price);
                    } else {
                        return UNSUITABLE_HOUSE;
                    }
                    break;

                case "ShorthairCat":
                    if (houseCollection.getClass().getSimpleName().equals("ShorthairCat")) {
                        addCat(houseName, catType, catName, catBreed, price);
                    } else {
                        return UNSUITABLE_HOUSE;
                    }
                    break;
            }
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
       return null;
    }

    @Override
    public String sumOfAll(String houseName) {
        return null;
    }

    @Override
    public String getStatistics() {
        return houseCollection.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
