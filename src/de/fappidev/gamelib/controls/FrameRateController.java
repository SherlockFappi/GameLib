package de.fappidev.gamelib.controls;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FrameRateController {
    private static int fps = 0;
    private static int ups = 0;
    private static int frames = 0;
    private static int updates = 0;
    static boolean isRunning = false;

    static ScheduledExecutorService executor;
    static Runnable runnable = () -> {
        fps = frames;
        frames = 0;
        ups = updates;
        updates = 0;
        System.out.println("FPS/UPS: " + getFps() + "/" + getUps());
    };

    public static void startFrameRateController () {
        executor = Executors.newScheduledThreadPool(1);
        isRunning = true;
        frames = 0;
        updates = 0;
        executor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    static void stopFrameRateController() {
        isRunning = false;
        executor.close();
    }

    static void addFps() {
        frames++;
    }

    static void addUps() {
        updates++;
    }

    public static int getFps() {
        return fps;
    }

    public static int getUps() {
        return ups;
    }
}
