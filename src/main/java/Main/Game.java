package Main;


import Entities.Entity;
import Entities.EntitySprite;
import Entities.Player;
import Entities.Sprite;
import World.World;
import com.sun.java.accessibility.util.AWTEventMonitor;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game implements Runnable {

    Boolean isRunning = true;
    private Thread thread;
    private World world;
    public static Player player;

    public static Sprite sprite;
    private Frame frame;
    private BufferedImage image;

    public ArrayList<Entity> entityList;

    public void tick(){
        for (int i = 0; i < entityList.size(); i++) {
            entityList.get(i).tick();
        }

    }

    public void render(){
        BufferStrategy bs = frame.getBufferStrategy();
        if (bs == null) {
            frame.createBufferStrategy(3);
            return;
        }
        //set o layer do fundo;
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Frame.winWidth, Frame.winHeight);
        /**/
        world.render(g);
        for (int i = 0; i < entityList.size(); i++) {
            entityList.get(i).render(g);
        }
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, Frame.winWidth * Frame.winScale, Frame.winHeight * Frame.winScale, null);
        bs.show();
    }

    public Game() throws IOException {
        image = new BufferedImage(Frame.winWidth, Frame.winHeight, BufferedImage.TYPE_INT_RGB);
        entityList = new ArrayList<Entity>();
        sprite = new Sprite(System.getProperty("user.dir") + "/src/main/image.png");
        world = new World(System.getProperty("user.dir") + "/src/main/map.png");
        player = new Player(16,16,16, EntitySprite.playerSprite);
        entityList.add(player);
        frame = new Frame();
        frame.newFrame(KeyBoard.keyListener());
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS:" + frames);
                frames = 0;
                timer += 1000;
            }
        }
        Stop();
    }

    /**
     * Inicia a Thread principal
     * */
    public synchronized void Start() {
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void Stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
