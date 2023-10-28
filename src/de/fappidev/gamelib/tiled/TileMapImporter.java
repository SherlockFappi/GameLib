package de.fappidev.gamelib.tiled;

import de.fappidev.gamelib.exceptions.FileFormatException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TileMapImporter {
    public static TileMap importTimeMap(File file) throws FileFormatException {
        if (!file.getPath().endsWith(".tmx")) {
            throw new FileFormatException("The file has to be of format \"tmx\"");
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line;
        do {
            line = scanner.nextLine();
        } while (!line.contains("<map version"));

        int width = 0;
        int height = 0;
        int tileWidth = 0;
        int tileHeight = 0;

        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            String tmp = lineScanner.next();
            if (tmp.contains("tilewidth")) {
                tileWidth = Integer.parseInt(tmp.substring(11, tmp.length() - 1));
            }
            else if (tmp.contains("tileheight")) {
                tileHeight = Integer.parseInt(tmp.substring(12, tmp.length() - 1));
            }
            else if (tmp.contains("width")) {
                width = Integer.parseInt(tmp.substring(7, tmp.length() - 1));
            }
            else if (tmp.contains("height")) {
                height = Integer.parseInt(tmp.substring(8, tmp.length() - 1));
            }
        }

        String sourcePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - file.getName().length());
        do {
            line = scanner.nextLine();
        } while (!line.contains("source="));

        lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            String tmp = lineScanner.next();
            if (tmp.contains("source=")) {
                sourcePath += tmp.substring(8, tmp.length() - 3);
            }
        }

        do {
            line = scanner.nextLine();
        } while (!line.contains("data encoding"));

        line = scanner.nextLine();
        int[][] map = new int[height][width];

        for (int i = 0; i < height; i++) {
            line = line.replaceAll(",", " ");
            lineScanner = new Scanner(line);

            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(lineScanner.next());
            }

            line = scanner.nextLine();
        }

        try {
            scanner = new Scanner(new File(sourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            line = scanner.nextLine();
        } while (!line.contains("image source"));

        File tileSet = null;
        lineScanner = new Scanner(line.replaceAll("[/\\]]", " "));
        while (lineScanner.hasNext()) {
            String tmp = lineScanner.next();
            if (tmp.contains(".bmp")) {
                tileSet = new File(file.getPath().replace(file.getName(), tmp.substring(8, tmp.length() - 1)));
            }
        }

        return new TileMap(map, tileWidth, tileHeight, tileSet);
    }
}
