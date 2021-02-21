package World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class World {

    private Tile[] tiles;
    private int mapWidth;
    private int mapHeight;

    public World(String path){
        try {
            BufferedImage map = ImageIO.read(new File(path));
            int[] pixels = new int[map.getWidth() * map.getHeight()];
            mapWidth = map.getWidth();
            mapHeight = map.getHeight();
            tiles = new Tile[map.getWidth() * map.getHeight()];
            map.getRGB(0,0,map.getWidth(),map.getHeight(),pixels,0,map.getWidth());

            for (int i = 0; i < map.getWidth(); i++) {
                for (int j = 0; j < map.getHeight(); j++) {

                    int pos = pixels[i + (j * map.getWidth())];

                    switch (pos){
                        case 0xFF19FF00:
                            tiles[i + ( j * mapWidth)] = new Tile(TileSprite.TileFloor,i*16,j*16);
                            break;
                        default:
                            tiles[i + ( j * mapWidth)] = new Tile(TileSprite.TileWall,i*16,j*16);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void render(Graphics g){
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Tile tile = tiles[i + (j * mapWidth)];
                tile.render(g);
            }
        }
    }

}
