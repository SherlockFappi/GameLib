package de.fappidev.gamelib.controls;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FrameRateController {
    private static int fps = 0;
    private static int ups = 0;
    private static int frames = 0;
    private static int updates = 0;

    Thread framerateThread = new Thread(new Runnable() {
        @Override
        public void run() {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(() -> {
                fps = frames;
                frames = 0;
                ups = updates;
                updates = 0;
                System.out.println("FPS/UPS: " + getFps() + "/" + getUps());
            }, 1, 1, TimeUnit.SECONDS);
        }
    });
    public FrameRateController () {
        framerateThread.start();
    }

    static void addFps() {
        frames++;
    }

    static void addUps() {
        updates++;
    }

    public int getFps() {
        return fps;
    }

    public int getUps() {
        return ups;
    }
}
