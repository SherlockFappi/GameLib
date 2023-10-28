package de.fappidev.gamelib.gameobjects.utils;

import java.util.ArrayList;
import java.util.Objects;

public class Dictionary<T> {
    private final ArrayList<String> identifierList;
    private final ArrayList<T> valueList;

    public Dictionary() {
        identifierList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    public void addEntry(String identifier, T value) {
        identifierList.add(identifier);
        valueList.add(value);
    }

    public T get(String identifier) {
        for (int i = 0; i < identifierList.size(); i++) {
            if (Objects.equals(identifier, identifierList.get(i))) {
                return valueList.get(i);
            }
        }

        return null;
    }

    public void updateStat(String identifier, T value) {
        for (int i = 0; i < identifierList.size(); i++) {
            if (Objects.equals(identifier, identifierList.get(i))) {
                valueList.set(i, value);
            }
        }
    }

    public int length() {
        return identifierList.size();
    }

    public T get(int i) {
        return valueList.get(i);
    }

    public void remove(int i) {
        identifierList.remove(i);
        valueList.remove(i);
    }

    public void remove(String s) {
        for (int i = 0; i < length(); i++) {
            if (Objects.equals(identifierList.get(i), s)) {
                identifierList.remove(i);
                valueList.remove(i);
                return;
            }
        }
    }
}
