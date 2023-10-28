package de.fappidev.gamelib.tiled;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileMap {
    private int[][] map;
    private int tileHeight;
    private int tileWidth;
    private BufferedImage tileset;
    private Image[][] img;
    private int columnCount;
    private int rowCount;

    public TileMap(int[][] map, int tileWidth, int tileHeight, File tileset) {
        this.map = map;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        try {
            this.tileset = ImageIO.read(tileset);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.rowCount = this.tileset.getWidth() / this.tileWidth;
        this.columnCount = this.tileset.getHeight() / this.tileHeight;

        img = new Image[this.tileset.getWidth() / this.tileWidth][this.tileset.getHeight() / this.tileHeight];
        for (int i = 0; i < rowCount; i ++) {
            for (int j = 0; j < columnCount; j++) {
                img[i][j] = this.tileset.getSubimage(i * this.tileWidth, j * this.tileHeight, this.tileWidth, this.tileHeight);
            }

        }
    }

    public void scaleTiles(float scale) {
        for (int i = 0; i < this.tileset.getWidth() / this.tileWidth; i ++) {
            for (int j = 0; j < this.tileset.getHeight() / this.tileHeight; j++) {
                img[i][j] = this.tileset.getSubimage(i * this.tileWidth, j * this.tileHeight, this.tileWidth, this.tileHeight).getScaledInstance((int) (this.tileWidth * scale), (int) (this.tileHeight * scale), Image.SCALE_DEFAULT);
            }
        }
    }

    public Image[][] getImage() {
        return this.img;
    }

    public int[][] getMap() {
        return this.map;
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getColumnCount() {
        return this.columnCount;
    }
}
