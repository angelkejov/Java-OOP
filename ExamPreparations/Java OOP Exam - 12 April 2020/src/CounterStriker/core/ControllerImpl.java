package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Pistol":
                Pistol pistol = new Pistol(name, bulletsCount);
                guns.add(pistol);
                break;
            case "Rifle":
                Rifle rifle = new Rifle(name, bulletsCount);
                guns.add(rifle);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gunToFind = null;
        switch (type) {
            case "Terrorist":
                gunToFind = guns.getModels().stream()
                        .filter(gun -> gun.getName().equals(gunName))
                        .findFirst()
                        .orElse(null);
                if (gunName == null) {
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);
                }
                Terrorist terrorist = new Terrorist(username, health, armor, gunToFind);
                this.players.add(terrorist);
                break;
            case "CounterTerrorist":
                gunToFind = guns.getModels().stream()
                        .filter(gun -> gun.getName().equals(gunName))
                        .findFirst()
                        .orElse(null);
                if (gunName == null) {
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);
                }
                CounterTerrorist counterTerrorist = new CounterTerrorist(username, health, armor, gunToFind);
                this.players.add(counterTerrorist);

                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);

        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER , username);
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

//    "{player type}: {player username}
//            --Health: {player health}
//--Armor: {player armor}
//--Gun: {player gun name}"


    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        return String.format(String.valueOf(stringBuilder.append(players.getModels().stream().sorted(
                Comparator.comparing(Object::toString)).collect(Collectors.toList()))));
    }
}
