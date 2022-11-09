package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Terrorist> terrorists = new ArrayList<>();
        List<CounterTerrorist> counterTerrorists = new ArrayList<>();
        for (Player player : players) {
            if (player.getClass()
                    .getSimpleName()
                    .equals("Terrorist")) {
                terrorists.add((Terrorist) player);
            }
        }
        for (Player player : players) {
            if (player.getClass()
                    .getSimpleName()
                    .equals("CounterTerrorist")) {
                counterTerrorists.add((CounterTerrorist) player);
            }
        }
        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()){
            for (int i = 0; i < terrorists.size(); i++) {
                int dmgToTake =  terrorists.get(i).getGun().fire();
                counterTerrorists.get(i).takeDamage(dmgToTake);
            }


        }
        return null;
    }
}
