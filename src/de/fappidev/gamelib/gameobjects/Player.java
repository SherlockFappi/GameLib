package de.fappidev.gamelib.gameobjects;

import de.fappidev.gamelib.gameobjects.utils.Dictionary;
import de.fappidev.gamelib.gameobjects.utils.Vector2;

import java.awt.*;

public class Player extends GameObject {
    public static int DEFAULT_MOVEMENT = 0;

    private double moveSpeed;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private int moveMode;
    private final Dictionary<Double> statList = new Dictionary<>();

    public Player(Vector2 pos, double moveSpeed, int moveMode, double xSize, double ySize, int shape) {
        super(pos, xSize, ySize);
        this.moveSpeed = moveSpeed;
        this.moveMode = moveMode;

        setShape(shape);
    }

    public void setMoveSpeed (double speed) {
        this.moveSpeed = speed;
    }

    public void setColor(Color color) {
        super.color = color;
    }

    public void moveUp(boolean b) {
        this.moveUp = b;
    }

    public void moveDown(boolean b) {
        this.moveDown = b;
    }

    public void moveLeft(boolean b) {
        this.moveLeft = b;
    }

    public void moveRight(boolean b) {
        this.moveRight = b;
    }

    public Vector2 getMoveDirection() {
        if (moveUp && !moveRight && !moveDown && !moveLeft) { // up
            if (moveMode == 0) {
                return new Vector2(0, -1);
            }
            else {
                return new Vector2(0, -1);
            }
        }
        else if (moveUp && moveRight && !moveDown && !moveLeft) { // up-right
            if (moveMode == 0) {
                return new Vector2(0.707, -0.707);
            }
            else {
                return new Vector2(1, -1);
            }
        }
        else if (!moveUp && moveRight && !moveDown && !moveLeft) { // right
            if (moveMode == 0) {
                return new Vector2(1, 0);
            }
            else {
                return new Vector2(1, 0);
            }
        }
        else if (!moveUp && moveRight && moveDown && !moveLeft) { // down-right
            if (moveMode == 0) {
                return new Vector2(0.707, 0.707);
            }
            else {
                return new Vector2(1, 1);
            }
        }
        else if (!moveUp && !moveRight && moveDown && !moveLeft) { // down
            if (moveMode == 0) {
                return new Vector2(0, 1);
            }
            else {
                return new Vector2(0, 1);
            }
        }
        else if (!moveUp && !moveRight && moveDown && moveLeft) { // down-left
            if (moveMode == 0) {
                return new Vector2(-0.707, 0.707);
            }
            else {
                return new Vector2(-1, 1);
            }
        }
        else if (!moveUp && !moveRight && !moveDown && moveLeft) { // left
            if (moveMode == 0) {
                return new Vector2(-1, 0);
            }
            else {
                return new Vector2(-1, 0);
            }
        }
        else if (moveUp && !moveRight && !moveDown && moveLeft) { // up-left
            if (moveMode == 0) {
                return new Vector2(-0.707, -0.707);
            }
            else {
                return new Vector2(-1, -1);
            }
        }
        else if (moveUp && !moveRight && moveDown && !moveLeft) {
            if (moveMode == 0) {
                return new Vector2(0, -1);
            }
            else {
                return new Vector2(0, -1);
            }
        }
        else if (!moveUp && moveRight && !moveDown && moveLeft) {
            if (moveMode == 0) {
                return new Vector2(1, 0);
            }
            else {
                return new Vector2(1, 0);
            }
        }
        else return new Vector2(0, 0);
    }

    public double getMoveSpeed() {
        return this.moveSpeed;
    }

    public Dictionary<Double> getStats() {
        return this.statList;
    }
}
