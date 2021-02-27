package Entities;

import java.awt.image.BufferedImage;

public class Player extends Entity{

    public Player(int x, int y, int eWidth, int eHeight, BufferedImage sprite) {
        super(x, y, eWidth, eHeight, sprite);
    }

    public Player(int x, int y, int spriteSize, BufferedImage sprite) {
        super(x, y, spriteSize, sprite);
    }

}
