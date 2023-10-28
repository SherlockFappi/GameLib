package de.fappidev.gamelib.gameobjects;

import de.fappidev.gamelib.gameobjects.utils.Transform;

public class GameObject {
    private Transform transform;

    public GameObject() {
        transform = new Transform();
    }

    public GameObject(int x, int y) {
        transform = new Transform(x, y);
    }
}
