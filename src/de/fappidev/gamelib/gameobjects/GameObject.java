package de.fappidev.gamelib.gameobjects;

import de.fappidev.gamelib.controls.UpdateThread;
import de.fappidev.gamelib.gameobjects.utils.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class GameObject {
    public static int NONE = 0;
    public static int RECT_SHAPE = 1;
    public static int CIRCLE_SHAPE = 2;

    private String shape = "NONE";

    private final ArrayList<GameObject> objectList = new ArrayList<>();
    private final Transform transform;
    protected Color color = Color.GRAY;
    private Thread thread;
    private Runnable runnable = null;
    private ScheduledExecutorService executor;
    private boolean updateTimeConfirmed = false;

    public GameObject() {
        transform = new Transform();
    }

    public GameObject(double x, double y) {
        transform = new Transform(x, y, 0, 0);
    }

    public GameObject(Vector2 vec, double xSize, double ySize) {
        transform = new Transform(vec, xSize, ySize);
    }

    public GameObject(double x, double y, double xSize, double ySize) {
        transform = new Transform(x, y,xSize, ySize);
    }

    public Transform transform() {
        return this.transform;
    }

    public Color getColor() {
        return this.color;
    }

    public void setShape(int shape) {
        switch (shape) {
            case 0 -> {
                this.shape = "NONE";
            }

            case 1 -> {
                this.shape = "RECT";
            }

            case 2 -> {
                this.shape = "CIRCLE";
            }

            default -> {
                this.shape = "NONE";
                System.err.println("Illegal Shape ID. Defaulting to NONE");
            }
        }
    }

    public String getShape() {
        return this.shape;
    }

    public ArrayList<GameObject> getObjectList() {
        return this.objectList;
    }

    public void addObject(GameObject obj) {
        obj.transform.setPosition(this.transform.getPosition().add(obj.transform().getPosition()));
        objectList.add(obj);
    }

    public int[] getRenderComponents() {
        int[] res = new int[4];
        res[0] = (int) this.transform.x();
        res[1] = (int) this.transform.y();
        res[2] = (int) this.transform.getxSize();
        res[3] = (int) this.transform.getySize();
        return res;
    }

    public boolean collides(GameObject obj) {
        if (this.transform.x() < obj.transform.x() + obj.transform.getxSize()) {
            if (this.transform.x() + this.transform().getxSize() > obj.transform.x()) {
                if (this.transform.y() < obj.transform.y() + obj.transform.getySize()) {
                    if (this.transform.y() + this.transform().getySize() > obj.transform.y()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void setBehaviour(Runnable runnable) {
        executor = Executors.newScheduledThreadPool(1);

        AtomicLong targetTime = new AtomicLong(UpdateThread.getTimePerUpdate());
        thread = new Thread(() -> {
            while (true) {
                while (targetTime.get() == 0) {
                    targetTime.set(UpdateThread.getTimePerUpdate());
                }

                long startTime = System.nanoTime();

                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException ignored) {

                }

                long updateTime = System.nanoTime() - startTime;

                if (updateTime < targetTime.get()) {
                    try {
                        Thread.sleep((targetTime.get() - updateTime) / 1000000);
                    } catch (InterruptedException e) {
                        try {
                            thread.join();
                        } catch (InterruptedException ex) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.start();
    }

    public void stopBehaviour() {
        executor.close();
        thread.interrupt();
    }

    public class Transform {
        private double x;
        private double y;
        private double xSize;
        private double ySize;
        private double xScale;
        private double yScale;

        public Transform() {
            this.x = 0;
            this.y = 0;
            this.xScale = 1;
            this.yScale = 1;
        }

        public Transform(double x, double y, double xSize, double ySize) {
            this.x = x;
            this.y = y;
            this.xScale = 1;
            this.yScale = 1;
            this.xSize = xSize;
            this.ySize = ySize;
        }

        public Transform(Vector2 vec, double xSize, double ySize) {
            this.x = vec.x;
            this.y = vec.y;
            this.xScale = 1;
            this.yScale = 1;
            this.xSize = xSize;
            this.ySize = ySize;
        }

        public void translate(Vector2 vec) {
            this.x += vec.x;
            this.y += vec.y;

            for (int i = 0; i < objectList.size(); i++) {
                objectList.get(i).transform.translate(vec);
            }
        }

        public void setPosition(Vector2 vec) {
            this.x = vec.x;
            this.y = vec.y;
        }

        public void setScale(double xScale, double yScale) {
            this.xScale = xScale;
            this.yScale = yScale;
        }

        public void setScale(double scale) {
            this.xScale = scale;
            this.yScale = scale;
            this.xSize *= xScale;
            this.ySize *= yScale;
        }

        public void setxScale(double xScale) {
            this.xScale = xScale;
        }

        public void setyScale(double yScale) {
            this.yScale = yScale;
        }

        public double getSize() {
            if (xSize == ySize) {
                return xSize;
            }

            else return 0;
        }

        public double getxSize() {
            return this.xSize;
        }

        public double getySize() {
            return this.ySize;
        }

        public double x() {
            return this.x;
        }

        public double y() {
            return this.y;
        }

        public Vector2 getPosition() {
            return new Vector2(this.x, this.y);
        }
    }
}
