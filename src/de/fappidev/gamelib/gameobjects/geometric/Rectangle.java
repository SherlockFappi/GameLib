package de.fappidev.gamelib.gameobjects.geometric;

import de.fappidev.gamelib.gameobjects.GameObject;

import java.awt.*;

public class Rectangle extends GameObject {
    public Rectangle(double x, double y, double xSize, double ySize) {
        super(x, y, xSize, ySize);
        super.color = Color.GRAY;
        setShape(GameObject.RECT_SHAPE);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
