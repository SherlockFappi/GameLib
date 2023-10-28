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

    public Vector2 normalize() {
        double magnitude = 1 / getMagnitude();
        return new Vector2(x * magnitude, y * magnitude);
    }

    public Vector2 multiply(Vector2 vec) {
        return new Vector2(this.x * vec.x, this.y * vec.y);
    }

    public Vector2 negate() {
        return new Vector2(-this.x, -this.y);
    }

    public Vector2 scale(double scale) {
        return new Vector2(this.x * scale, this.y * scale);
    }

    public static Vector2 up() {
        return new Vector2(0, 1.0);
    }

    public static Vector2 down() {
        return new Vector2(0, -1.0);
    }

    public static Vector2 left() {
        return new Vector2(-1, 0);
    }

    public static Vector2 right() {
        return new Vector2(1.0, 0);
    }

    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }

    public Vector2 add(Vector2 vec) {
        return new Vector2(this.x + vec.x, this.y + vec.y);
    }
}
