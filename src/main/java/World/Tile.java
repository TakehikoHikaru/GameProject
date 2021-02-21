package World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage sprite;
    private int x;
    private int y;

    public Tile(BufferedImage sprite, int x, int y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g){

    }
}
