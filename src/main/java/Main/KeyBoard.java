package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard {

    public static KeyListener keyListener() {
        return new KeyListener() {
            public void keyTyped(KeyEvent e) {


            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    Game.player.setX(Game.player.getX() + 10);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    Game.player.setX(Game.player.getX() - 10);
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Game.player.setY(Game.player.getY() - 10);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    Game.player.setY(Game.player.getY() + 10);
                }
            }

            public void keyReleased(KeyEvent e) {

            }
        };
    }
}