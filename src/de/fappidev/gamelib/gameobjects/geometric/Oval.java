package de.fappidev.gamelib.gameobjects.geometric;

import de.fappidev.gamelib.gameobjects.GameObject;

import java.awt.*;

public class Oval extends GameObject {
    public Oval(double x, double y, double xSize, double ySize) {
        super(x, y, xSize, ySize);
        super.color = Color.GRAY;
        setShape(GameObject.CIRCLE_SHAPE);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
