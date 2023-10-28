package de.fappidev.gamelib.gameobjects.utils;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getMagnitude () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void normalize() {
        double magnitude = 1 / getMagnitude();
        x = magnitude * x;
        y = magnitude * y;
    }

    public Vector2 getNormalized() {
        double magnitude = 1 / getMagnitude();
        return new Vector2(x * magnitude, y * magnitude);
    }

    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
}
