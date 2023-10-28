package game;

import de.fappidev.gamelib.gameobjects.Player;
import de.fappidev.gamelib.gameobjects.utils.Dictionary;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter  {
    private final Player player;
    Dictionary<Double> playerStats;

    public KeyController() {
        player = (Player) Main.objectList.get("Player");
        playerStats = player.getStats();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
