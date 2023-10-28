package game;

import de.fappidev.gamelib.controls.GameFrame;
import de.fappidev.gamelib.gameobjects.GameObject;
import de.fappidev.gamelib.gameobjects.utils.Dictionary;

import java.awt.*;

public class Main {
    static GameFrame frame;
    static GamePanel gamePanel;
    public static Dictionary<GameObject> objectList;

    // Launch Settings
    static Dimension windowDimension = new Dimension(800, 600);
    static boolean fullScreen = false;
    static int targetFPS = 60;
    static int targetUPS = 60;

    // GameObjects

    // UI Elements

    // executed every update
    public static void update() {

    }

    // executed every render frame
    public static void render() {
        frame.repaint();
    }

    // used to initialize GameObjects
    private static void initObjects() {

    }

    // used to initialize UI Components
    private static void initUI () {

    }

    public static void main(String[] args) {
        objectList = new Dictionary<>();
        gamePanel = new GamePanel();
        initObjects();
        initUI();
        frame = new GameFrame(windowDimension, fullScreen, new KeyController(), targetFPS, targetUPS);
        frame.addPanel(gamePanel, GameFrame.CENTER);
    }
}
