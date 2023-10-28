package game;

import de.fappidev.gamelib.gameobjects.GameObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int[] renderComponents;

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < Main.objectList.length(); i++) {
            GameObject obj = Main.objectList.get(i);
            renderComponents = obj.getRenderComponents();
            g.setColor(obj.getColor());
            switch (obj.getShape()) {
                case "NONE" -> {
                    continue;
                }

                case "RECT" -> {
                    g.fillRect(renderComponents[0], renderComponents[1], renderComponents[2], renderComponents[3]);
                }

                case "CIRCLE" -> {
                    g.fillOval(renderComponents[0], renderComponents[1], renderComponents[2], renderComponents[3]);
                }
            }

            for (int j = 0; j < obj.getObjectList().size(); j++) {
                GameObject subOBJ = obj.getObjectList().get(j);
                g.setColor(subOBJ.getColor());
                renderComponents = subOBJ.getRenderComponents();

                switch (subOBJ.getShape()) {
                    case "NONE" -> {
                        continue;
                    }

                    case "RECT" -> {
                        g.fillRect(renderComponents[0], renderComponents[1], renderComponents[2], renderComponents[3]);
                    }

                    case "CIRCLE" -> {
                        g.fillOval(renderComponents[0], renderComponents[1], renderComponents[2], renderComponents[3]);
                    }
                }
            }

        }
    }
}
