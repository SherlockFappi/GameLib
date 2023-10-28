package de.fappidev.gamelib.gameobjects.utils;

import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {
    private ArrayList<String> identifierList;
    private ArrayList<Double> valueList;

    public Dictionary() {
        identifierList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    public void addEntry(String identifier, double value) {
        identifierList.add(identifier);
        valueList.add(value);
    }

    public double getValue(String identifier) {
        for (int i = 0; i < identifierList.size(); i++) {
            if (Objects.equals(identifier, identifierList.get(i))) {
                return valueList.get(i);
            }
        }

        return 0.0;
    }

    public void updateStat(String identifier, double value) {
        for (int i = 0; i < identifierList.size(); i++) {
            if (Objects.equals(identifier, identifierList.get(i))) {
                valueList.set(i, value);
            }
        }
    }
}
