package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    static BufferedImage image;

    public Sprite(String path) throws IOException {
        image = ImageIO.read(new File(path));
    }

    public static BufferedImage getSprite(int spriteSize, int x, int y){
        return image.getSubimage(x, y, spriteSize, spriteSize);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height){
        return image.getSubimage(x, y, width, height);
    }
}
