package Main;


import Entities.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    Boolean isRunning = true;
    private Thread thread;

    private Sprite sprite;
    private Frame frame;
    private BufferedImage image;

    public void tick(){}

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
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, Frame.winWidth * Frame.winScale, Frame.winHeight * Frame.winScale, null);
        bs.show();
    }

    public Game(){
       // sprite = new Sprite(System.getProperty("user.dir") + "/src/main/image.png");
        image = new BufferedImage(Frame.winWidth, Frame.winHeight, BufferedImage.TYPE_INT_RGB);

        frame = new Frame();
        frame.newFrame();
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
