package de.fappidev.gamelib.controls;

import game.Main;

public class UpdateThread extends Thread implements Runnable {
    private static long targetTime;

    public UpdateThread(int ups) {
        targetTime = 1000000000 / ups;
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.nanoTime();

            Main.update();

            long updateTime = System.nanoTime() - startTime;

            if (updateTime < targetTime) {
                try {
                    Thread.sleep((targetTime - updateTime) / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            FrameRateController.addUps();
        }
    }

    public static long getTimePerUpdate() {
        return targetTime;
    }
}
