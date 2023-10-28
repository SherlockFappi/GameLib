package de.fappidev.gamelib.controls;

import test.Main;

import java.awt.*;

public class RenderThread extends Thread implements Runnable {
    private static long targetTime;

    public RenderThread(int fps) {
        targetTime = 1000000000 / fps;
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.nanoTime();

            Toolkit.getDefaultToolkit().sync();
            Main.render();

            long updateTime = System.nanoTime() - startTime;

            if (updateTime < targetTime) {
                try {
                    Thread.sleep((targetTime - updateTime) / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            FrameRateController.addFps();
        }
    }
}
