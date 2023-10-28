package de.fappidev.gamelib.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameFrame extends JFrame {
    public static int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;
    public static int CENTER = 4;

    private final Properties appProps;

    public GameFrame (Dimension dimension, boolean fullScreen, KeyAdapter keyAdapter, int targetFps, int targetUps) {
        super();
        appProps = new Properties();
        try {
            appProps.load(new FileInputStream("src/de/fappidev/gamelib/properties/app.properties"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: app.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle(appProps.getProperty("app.name") + " " + appProps.getProperty("app.version"));

        if (keyAdapter != null) {
            addKeyListener(keyAdapter);
        }

        if (fullScreen) {
            setUndecorated(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setAlwaysOnTop(true);
        }
        if (dimension != null) {
            setSize(dimension);
        } else {
            setSize(800, 600);
        }
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setVisible(true);

        UpdateThread updateThread = new UpdateThread(targetUps);
        updateThread.start();
        RenderThread renderThread = new RenderThread(targetFps);
        renderThread.start();
    }

    public void printFrameRate(boolean b) {
        if (b && !FrameRateController.isRunning) {
            FrameRateController.startFrameRateController();
        }
        else if (!b && FrameRateController.isRunning) {
            FrameRateController.stopFrameRateController();
        }
    }

    public boolean getPrintFrameRate() {
        return FrameRateController.isRunning;
    }

    public void addPanel(JPanel panel, int position) {
        try {
            switch (position) {
                case 0 -> {
                    add(panel, BorderLayout.NORTH);
                    System.out.println("game");
                }
                case 1 -> add(panel, BorderLayout.EAST);
                case 2 -> add(panel, BorderLayout.SOUTH);
                case 3 -> add(panel, BorderLayout.WEST);
                case 4 -> add(panel, BorderLayout.CENTER);
                default -> throw new IllegalArgumentException("No valid position was given");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void showVersionInTitle(boolean b) {
        if (b) {
            setTitle(appProps.getProperty("app.name") + " " + appProps.getProperty("app.version"));
        }
        else {
            setTitle(appProps.getProperty("app.name"));
        }
    }
}
