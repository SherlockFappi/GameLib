package test;

import de.fappidev.gamelib.gameobjects.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter  {
    private final Player player;

    public KeyController() {
        player = (Player) Main.objectList.getValue("Player");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
}
