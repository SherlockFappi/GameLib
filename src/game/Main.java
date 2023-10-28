package test;

import de.fappidev.gamelib.controls.GameFrame;
import de.fappidev.gamelib.gameobjects.GameObject;
import de.fappidev.gamelib.gameobjects.Player;
import de.fappidev.gamelib.gameobjects.geometric.Square;
import de.fappidev.gamelib.gameobjects.utils.Dictionary;
import de.fappidev.gamelib.gameobjects.utils.Vector2;

import java.awt.*;

public class Main {
    static GameFrame frame;
    static Player player = new Player(new Vector2(0, 0), 5.0, Player.DEFAULT_MOVEMENT, 100, 100);
    public static Dictionary<GameObject> objectList;

    public static void update() {
        player.transform().translate(player.getMoveDirection().scale(player.getMoveSpeed()));
    }

    public static void render() {
        frame.repaint();
    }

    private static void initObjects() {
        Square background = new Square(0, 0, 800);

        player.setColor(Color.RED);
        background.setColor(Color.DARK_GRAY);

        objectList.addEntry("Player", player);
        objectList.addEntry("Background", background);
    }

    public static void main(String[] args) {
        objectList = new Dictionary<>();
        initObjects();
        frame = new GameFrame(new Dimension(800, 600), false, new KeyController(), 60, 60);
        frame.addPanel(new GamePanel(), GameFrame.CENTER);
    }
}
