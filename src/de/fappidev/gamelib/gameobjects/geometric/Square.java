package de.fappidev.gamelib.gameobjects.geometric;

import de.fappidev.gamelib.gameobjects.GameObject;

import java.awt.*;

public class Square extends GameObject {
    public Square(double x, double y, double size) {
        super(x, y, size, size);
        super.color = Color.GRAY;
        setShape(GameObject.RECT_SHAPE);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
