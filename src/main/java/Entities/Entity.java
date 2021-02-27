package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private int x;
    private int y;
    private int eWidth;
    private int eHeight;

    private BufferedImage sprite;

    public Entity(int x, int y, int eWidth, int eHeight, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.eWidth = eWidth;
        this.eHeight = eHeight;
        this.sprite = sprite;
    }

    public Entity(int x, int y, int spriteSize, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.eWidth = spriteSize;
        this.eHeight = spriteSize;
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int geteWidth() {
        return eWidth;
    }

    public void seteWidth(int eWidth) {
        this.eWidth = eWidth;
    }

    public int geteHeight() {
        return eHeight;
    }

    public void seteHeight(int eHeight) {
        this.eHeight = eHeight;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void tick(){

    }

    public void render(Graphics g) {
        g.drawImage(this.sprite, this.x, this.y, null);
    }
}
