package test;

import de.fappidev.gamelib.gameobjects.Player;
import de.fappidev.gamelib.gameobjects.geometric.Square;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Square background = (Square) Main.objectList.getValue("Background");
    private final Player player = (Player) Main.objectList.getValue("Player");


    @Override
    public void paintComponent(Graphics g) {
        g.setColor(background.getColor());
        g.fillRect((int) background.transform().x(), (int) background.transform().y(), (int) background.transform().getSize(), (int) background.transform().getSize());

        g.setColor(player.getColor());
        g.fillRect((int) player.transform().x(), (int) player.transform().y(), (int) player.transform().getSize(), (int) player.transform().getSize());
    }
}
